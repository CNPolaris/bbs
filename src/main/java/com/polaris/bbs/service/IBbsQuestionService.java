package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.question.QuestionPage;
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
}
