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
@Api(tags = {"管理员端", "系统管理模块"})
@RestController("AdminController")
@RequestMapping("/api/bbs/admin")
public class BbsAdminController {
}
