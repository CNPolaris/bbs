package com.polaris.bbs.controller.user;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.common.dto.Response;
import com.polaris.bbs.dto.editor.tutor.TutorEditResponse;
import com.polaris.bbs.dto.editor.tutor.TutorPageQuery;
import com.polaris.bbs.pojo.BbsTutor;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsTutorService;
import com.polaris.bbs.service.IBbsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;

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
    private static final Logger logger = LoggerFactory.getLogger(BbsQuestionController.class);

    private final IBbsUserService userService;
    private final IBbsTutorService tutorService;

    public BbsTutorController(IBbsUserService userService, IBbsTutorService tutorService) {
        this.userService = userService;
        this.tutorService = tutorService;
    }

    @ApiOperation("编辑导师推荐信息")
    @PostMapping("/edit")
    public RespBean editTutor(Principal principal, @RequestBody BbsTutor model){
        BbsUser bbsUser = userService.selectUserByUserName(principal.getName());
        if(model.getCreateUser()==null){
            model.setCreateUser(bbsUser.getId());
        }
        BbsTutor bbsTutor = tutorService.editTutor(model);
        TutorEditResponse tutorEditResponse = BeanUtil.copyProperties(bbsTutor, TutorEditResponse.class);
        tutorEditResponse.setCreateUserAvatar(bbsUser.getAvatar());
        logger.info("用户{}编辑了导师推荐信息",bbsUser.getUserName());
        return RespBean.success("编辑推荐导师信息成功",tutorEditResponse);
    }

    @ApiOperation("用户获取个人发布的导师推荐信息")
    @PostMapping("/user/list")
    public RespBean userCreateTutorList(Principal principal, @RequestBody TutorPageQuery model){
        Page<BbsTutor> tutorPage = tutorService.getUserCreateTutorList(userService.selectUserByUserName(principal.getName()).getId(), model);
        Response response = new Response(tutorPage.getTotal(), Arrays.asList(tutorPage.getRecords().toArray()));
        return RespBean.success(response);
    }
}
