package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.question.AnswerRequest;
import com.polaris.bbs.dto.editor.question.QuestionPage;
import com.polaris.bbs.pojo.BbsQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
public interface IBbsQuestionService extends IService<BbsQuestion> {
    /**
     * 编辑问答
     * @param userId Long
     * @param model BbsQuestion
     * @param request HttpServletRequest
     * @return BbsQuestion
     */
    BbsQuestion editQuestion(Long userId, BbsQuestion model, HttpServletRequest request);

    /**
     * 分页查询问答
     * @param model QuestionPage
     * @return Page<BbsQuestion>
     */
    Page<BbsQuestion> getQuestionPage(QuestionPage model);

    /**
     * 获取用户个人发表的问答列表
     * @param userId Long
     * @param model QuestionPage
     * @return Page<BbsQuestion>
     */
    Page<BbsQuestion> getPersonalQuestionList(Long userId, QuestionPage model);

    /**
     * 用户删除自己创建的问答（删除时会自动删除相关的回答记录）
     * @param userId Long
     * @param questionId Long
     * @return Long
     */
    int deletePersonalQuestion(Long userId, Long questionId);

    /**
     * 设置回答的状态（0：无效 1：有效 2：暂定）
     * @param userId Long
     * @param model AnswerRequest
     * @return BbsQuestion
     */
    BbsQuestion setQuestionAnswerStatus(Long userId, AnswerRequest model);
}
