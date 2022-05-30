package com.polaris.bbs.service.impl;

import com.polaris.bbs.pojo.LoginLog;
import com.polaris.bbs.mapper.LoginLogMapper;
import com.polaris.bbs.service.ILoginLogService;
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
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
