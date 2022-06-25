package com.polaris.bbs.controller.user;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.dto.question.AnswerResponse;
import com.polaris.bbs.dto.question.QuestionAnswerPage;
import com.polaris.bbs.dto.question.QuestionPage;
import com.polaris.bbs.dto.question.QuestionResponse;
import com.polaris.bbs.pojo.BbsAnswer;
import com.polaris.bbs.pojo.BbsQuestion;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsAnswerService;
import com.polaris.bbs.service.IBbsQuestionService;
import com.polaris.bbs.service.IBbsSectionService;
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
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
@Api(tags = {"用户端","问答模块"})
@RestController("UserQuestionController")
@RequestMapping("/api/bbs/question")
public class BbsQuestionController {
    private static final Logger logger = LoggerFactory.getLogger(BbsQuestionController.class);

    private final IBbsQuestionService questionService;
    private final IBbsUserService userService;
    private final IBbsSectionService sectionService;
    private final IBbsAnswerService answerService;

    public BbsQuestionController(IBbsQuestionService questionService, IBbsUserService userService, IBbsSectionService sectionService, IBbsAnswerService answerService) {
        this.questionService = questionService;
        this.userService = userService;
        this.sectionService = sectionService;
        this.answerService = answerService;
    }

    @ApiOperation("编辑问答")
    @PostMapping("/edit")
    public RespBean editQuestion(Principal principal, @RequestBody BbsQuestion model, HttpServletRequest request) {
        BbsQuestion bbsQuestion = questionService.editQuestion(userService.selectUserByUserName(principal.getName()).getId(), model, request);
        logger.info("用户：{} 发表了新的问题",principal.getName());
        return RespBean.success("问题发布成功", bbsQuestion);
    }

    @ApiOperation("问答列表")
    @PostMapping("/page")
    public RespBean questionPage(@RequestBody QuestionPage model) {
        Page<BbsQuestion> questionPage = questionService.getQuestionPage(model);
        HashMap<String, Object> response = new HashMap<>(2);
        response.put("total", questionPage.getTotal());
        List<QuestionResponse> questionList = new ArrayList<>();
        questionPage.getRecords().forEach(question -> {
            QuestionResponse questionResponse = BeanUtil.copyProperties(question, QuestionResponse.class);
            questionResponse.setSection(sectionService.getById(question.getSectionId()).getName());
            BbsUser user = userService.getById(question.getCreateUser());
            questionResponse.setNickName(user.getNickName());
            questionResponse.setAvatar(user.getAvatar());
            questionList.add(questionResponse);
        });
        response.put("list", questionList);
        return RespBean.success("获取问答列表", response);
    }

    @ApiOperation("查看详情")
    @GetMapping("/select/{id}")
    public RespBean selectQuestion(@PathVariable Long id) {
        // 查找问答
        BbsQuestion bbsQuestion = questionService.getById(id);
        // 增加阅读次数
        Integer readCount = bbsQuestion.getReadCount() + 1;
        bbsQuestion.setReadCount(readCount);
        questionService.updateById(bbsQuestion);
        // 问答内容
        QuestionResponse questionResponse = BeanUtil.copyProperties(bbsQuestion, QuestionResponse.class);
        questionResponse.setSection(sectionService.getById(bbsQuestion.getSectionId()).getName());
        questionResponse.setNickName(userService.getById(bbsQuestion.getCreateUser()).getNickName());

        return RespBean.success(questionResponse);
    }

    @ApiOperation("获取答案")
    @PostMapping("/answer/list")
    public RespBean getAnswerAndReply(@RequestBody QuestionAnswerPage model){
        List<AnswerResponse> answerList = new ArrayList<>(model.getLimit());
        Page<BbsAnswer> answerPage = answerService.getAnswerPage(model);
        Map<String, Object> response = new HashMap<>(2);
        response.put("total", answerPage.getTotal());
        answerPage.getRecords().forEach(answer -> {
            AnswerResponse answerResponse = BeanUtil.copyProperties(answer, AnswerResponse.class);
            BbsUser bbsUser = userService.getById(answer.getCreateUser());
            answerResponse.setNickName(bbsUser.getNickName());
            answerResponse.setAvatar(bbsUser.getAvatar());
            answerList.add(answerResponse);
        });
        response.put("list", answerList);
        return RespBean.success(response);
    }
}
