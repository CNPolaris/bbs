package com.polaris.bbs.service.impl;

import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.mapper.BbsUserMapper;
import com.polaris.bbs.service.IBbsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
