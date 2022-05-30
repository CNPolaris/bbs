package com.polaris.bbs.mapper;

import com.polaris.bbs.pojo.BbsUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.polaris.bbs.pojo.Permission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface BbsUserMapper extends BaseMapper<BbsUser> {
    List<Permission> getPermissionList(Long roleId);
}
