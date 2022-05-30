package com.polaris.bbs.service;

import com.polaris.bbs.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 获取全部的权限列表
     * @return List
     */
    List<Permission> queryAll();
}
