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
 * @since 2022-06-25
 */
@Api(tags={"用户端", "回答模块"})
@RestController("UserAnswerController")
@RequestMapping("/api/bbs/answer")
public class BbsAnswerController {

}
