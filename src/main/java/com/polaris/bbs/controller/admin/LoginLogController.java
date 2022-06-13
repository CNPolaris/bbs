package com.polaris.bbs.controller.admin;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Api(tags = {"管理员端","登录日志管理模块"})
@RestController("AdminLoginLogController")
@RequestMapping("/api/bbs/admin/log")
public class LoginLogController {

}
