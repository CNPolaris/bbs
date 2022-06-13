package com.polaris.bbs.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.common.enums.RoleEnum;
import com.polaris.bbs.common.utils.StringUtils;
import com.polaris.bbs.dto.user.LoginParam;
import com.polaris.bbs.dto.user.UserInfoResponse;
import com.polaris.bbs.dto.user.UserRegisterParam;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.security.util.JwtTokenUtil;
import com.polaris.bbs.service.IBbsUserService;
import com.polaris.bbs.service.OssAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author CNPolaris
 * @version 1.0
 */
@RestController("CommonController")
@RequestMapping("/api/bbs")
@Api(tags="通用模块")
public class CommonController {
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    private final IBbsUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final OssAdminService ossAdminService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    public CommonController(IBbsUserService userService, PasswordEncoder passwordEncoder, OssAdminService ossAdminService, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.ossAdminService = ossAdminService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public RespBean login(@RequestBody LoginParam model, HttpServletRequest request){
        if(model.equals(null)){
            return RespBean.error("不能为空");
        }
        //登陆
        String token = null;
        UserDetails userDetails = userDetailsService.loadUserByUsername(model.getUsername());
        if (userDetails == null || ! passwordEncoder.matches(model.getPassword(), userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        //用户是否禁用
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用,请联系管理员");
        }
        try {
            // 更新security登陆对象
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            // 生成Token
            token = jwtTokenUtil.generatorToken(userDetails);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登陆成功", tokenMap);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public RespBean getUserInfo(Principal principal){
        BbsUser user = userService.selectUserByUserName(principal.getName());
        UserInfoResponse infoResponse = BeanUtil.copyProperties(user, UserInfoResponse.class);
        return RespBean.success(infoResponse);
    }

    @ApiOperation(value = "普通用户注册")
    @PostMapping("/register")
    public RespBean register(@RequestBody UserRegisterParam model) {
        if(model == null){
            return RespBean.error("参数不能为空");
        }
        if(StrUtil.isBlank(model.getUserName())||StrUtil.isBlank(model.getPasswordOne())||StrUtil.isBlank(model.getPasswordTwo())){
            return RespBean.error("账号或密码不能为空");
        }
        if(!Objects.equals(model.getPasswordOne(), model.getPasswordTwo())){
            return RespBean.error("两次输入密码不正确");
        }
        if(userService.selectUserByUserName(model.getUserName())!=null){
            return RespBean.error("用户已存在");
        }
        BbsUser user = new BbsUser();
        user.setUserName(model.getUserName());
        user.setNickName(model.getUserName());
        user.setPassword(passwordEncoder.encode(model.getPasswordOne()));
        user.setRoleId(RoleEnum.User.getCode());
        user.setCreateTime(new Date());
        userService.save(user);
        return RespBean.success("用户注册成功");
    }

    @ApiOperation(value = "上传图片")
    @PostMapping("/image/upload")
    public RespBean uploadImage(@RequestBody MultipartFile file) throws IOException {
        try {
            if(file.isEmpty()){
                return RespBean.error("图片不能为空");
            }
            String imgName = StringUtils.getRandomImgName(file.getOriginalFilename());
            String image = ossAdminService.uploadImage(file.getInputStream(), imgName);
            if(image.isEmpty()){
                return RespBean.error("上传图片失败");
            }
            return RespBean.success("上传图片成功",image);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return RespBean.error("上传失败");
    }

    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public RespBean logout(Principal principal) {
        return RespBean.success("注销成功");
    }
}
