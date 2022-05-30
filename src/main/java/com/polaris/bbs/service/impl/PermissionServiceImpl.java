package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.bbs.common.enums.StatusEnum;
import com.polaris.bbs.pojo.Permission;
import com.polaris.bbs.mapper.PermissionMapper;
import com.polaris.bbs.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    private final PermissionMapper permissionMapper;

    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> queryAll() {
        List<Permission> permissionAll = permissionMapper.selectList(new QueryWrapper<Permission>().eq("status", StatusEnum.OK.getCode()));
        return permissionAll;
    }
}
