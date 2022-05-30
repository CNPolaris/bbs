package com.polaris.bbs.service;

import com.polaris.bbs.pojo.BbsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface IBbsUserService extends IService<BbsUser> {
    /**
     * 根据用户名查询用户详情
     * @param username 用户名
     * @return RespBean
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 通过用户名获取用户
     * @param userName String
     * @return BbsUser
     */
    BbsUser selectUserByUserName(String userName);
}
