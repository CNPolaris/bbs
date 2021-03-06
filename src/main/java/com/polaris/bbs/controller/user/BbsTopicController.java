package com.polaris.bbs.controller.user;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.dto.editor.topic.TopicEdit;
import com.polaris.bbs.dto.editor.topic.TopicRequestPage;
import com.polaris.bbs.dto.editor.topic.TopicResponsePage;
import com.polaris.bbs.pojo.BbsTopic;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsSectionService;
import com.polaris.bbs.service.IBbsTopicService;
import com.polaris.bbs.service.IBbsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Api(tags={"用户端","文章模块"})
@RestController("UserTopicController")
@RequestMapping("/api/bbs/topic")
public class BbsTopicController {
    private static final Logger logger = LoggerFactory.getLogger(BbsTopicController.class);
    private final IBbsUserService userService;
    private final IBbsTopicService topicService;
    private final IBbsSectionService sectionService;
    public BbsTopicController(IBbsUserService userService, IBbsTopicService topicService, IBbsSectionService sectionService) {
        this.userService = userService;
        this.topicService = topicService;
        this.sectionService = sectionService;
    }


    @ApiOperation("分页获取帖子")
    @PostMapping("/page")
    public RespBean getTopicPage(@RequestBody TopicRequestPage model){
        Page<BbsTopic> topicPage = topicService.getTopicPage(model);
        HashMap<String, Object> response = new HashMap<>(2);
        response.put("total", topicPage.getTotal());
        List<TopicResponsePage> topicList = new ArrayList<TopicResponsePage>(model.getLimit());
        topicPage.getRecords().forEach(bbsTopic -> {
            TopicResponsePage topic = BeanUtil.copyProperties(bbsTopic, TopicResponsePage.class);
            topic.setSection(sectionService.getById(bbsTopic.getSectionId()).getName());
            BbsUser bbsUser = userService.getById(bbsTopic.getCreateUser());
            topic.setNickName(bbsUser.getNickName());
            topic.setAvatar(bbsUser.getAvatar());
            topicList.add(topic);
        });
        response.put("list", topicList);
        return RespBean.success("分页查询帖子成功", response);
    }

    @ApiOperation("编辑帖子")
    @PostMapping("/edit")
    public RespBean createTopic(Principal principal, @RequestBody TopicEdit model, HttpServletRequest request) {
        BbsUser bbsUser = userService.selectUserByUserName(principal.getName());
        BbsTopic bbsTopic = topicService.editTopic(bbsUser.getId(), model, request);
        logger.info("用户：{}编辑了文章",principal.getName());
        return RespBean.success(bbsTopic);
    }

    @ApiOperation("查看详情")
    @GetMapping("/select/{id}")
    public RespBean selectTopic(@PathVariable Long id){
        // 查找文章
        BbsTopic bbsTopic = topicService.getById(id);
        // 增加阅读次数
        Integer readCount = bbsTopic.getReadCount() + 1;
        bbsTopic.setReadCount(readCount);
        topicService.updateById(bbsTopic);

        TopicResponsePage topicResponse = BeanUtil.copyProperties(bbsTopic, TopicResponsePage.class);
        topicResponse.setSection(sectionService.getById(bbsTopic.getSectionId()).getName());
        BbsUser bbsUser = userService.getById(bbsTopic.getCreateUser());
        topicResponse.setNickName(bbsUser.getNickName());

        return RespBean.success(topicResponse);
    }
}
