package com.polaris.bbs.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.dto.topic.TopicEdit;
import com.polaris.bbs.dto.topic.TopicRequestPage;
import com.polaris.bbs.pojo.BbsTopic;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsContentService;
import com.polaris.bbs.service.IBbsTopicService;
import com.polaris.bbs.service.IBbsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Api(tags="帖子管理模块")
@RestController
@RequestMapping("/api/bbs/topic")
public class BbsTopicController {
    private final IBbsUserService userService;
    private final IBbsTopicService topicService;
    private final IBbsContentService contentService;
    public BbsTopicController(IBbsUserService userService, IBbsTopicService topicService, IBbsContentService contentService) {
        this.userService = userService;
        this.topicService = topicService;
        this.contentService = contentService;
    }


    @ApiOperation("分页获取帖子")
    @PostMapping("/page")
    public RespBean getTopicPage(@RequestBody TopicRequestPage model){
        Page<BbsTopic> topicPage = topicService.getTopicPage(model);
        HashMap<String, Object> response = new HashMap<>(2);
        response.put("total", topicPage.getTotal());
        response.put("list", topicPage.getRecords());
        return RespBean.success("分页查询帖子成功", response);
    }

    @ApiOperation("编辑帖子")
    @PostMapping("/edit")
    public RespBean createTopic(Principal principal, @RequestBody TopicEdit model) {
        BbsUser bbsUser = userService.selectUserByUserName(principal.getName());
        BbsTopic bbsTopic = topicService.editTopic(bbsUser.getId(), model);
        return RespBean.success(bbsTopic);
    }
}
