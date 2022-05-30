package com.polaris.bbs.controller;

import cn.hutool.core.util.StrUtil;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.common.enums.RoleEnum;
import com.polaris.bbs.common.utils.StringUtils;
import com.polaris.bbs.dto.user.UserRegisterParam;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsUserService;
import com.polaris.bbs.service.OssAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author CNPolaris
 * @version 1.0
 */
@RestController
@RequestMapping("/api/bbs")
@Api(tags="通用模块")
public class CommonController {
    private final IBbsUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final OssAdminService ossAdminService;
    public CommonController(IBbsUserService userService, PasswordEncoder passwordEncoder, OssAdminService ossAdminService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.ossAdminService = ossAdminService;
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
}
