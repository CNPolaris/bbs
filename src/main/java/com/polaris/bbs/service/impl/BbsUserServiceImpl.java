package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.bbs.bo.AdminUserDetails;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.mapper.BbsUserMapper;
import com.polaris.bbs.pojo.Permission;
import com.polaris.bbs.security.util.JwtTokenUtil;
import com.polaris.bbs.service.IBbsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Service
public class BbsUserServiceImpl extends ServiceImpl<BbsUserMapper, BbsUser> implements IBbsUserService {
    private final BbsUserMapper userMapper;

    public BbsUserServiceImpl(BbsUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        BbsUser user = userMapper.selectOne(new QueryWrapper<BbsUser>().eq("user_name", username));
        if(user!=null){
            List<Permission> permissionList = userMapper.getPermissionList(user.getRoleId());
            return new AdminUserDetails(user,permissionList);
        }
        throw new UsernameNotFoundException("用户不存在");
    }

    @Override
    public BbsUser selectUserByUserName(String userName) {
        if(userName.isEmpty()){
            return null;
        }
        return userMapper.selectOne(new QueryWrapper<BbsUser>().eq("user_name", userName));
    }
}
