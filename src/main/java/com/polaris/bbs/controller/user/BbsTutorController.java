package com.polaris.bbs.controller.user;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-07-12
 */
@Api(tags={"用户端", "导师推荐模块","导师信息模块"})
@RestController("UserTutorController")
@RequestMapping("/api/bbs/tutor")
public class BbsTutorController {

}
