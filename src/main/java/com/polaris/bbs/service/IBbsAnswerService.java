package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.question.QuestionAnswerPage;
import com.polaris.bbs.pojo.BbsAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
public interface IBbsAnswerService extends IService<BbsAnswer> {
    /**
     * 获取分页
     * @param model QuestionAnswerPage
     * @return Page<BbsAnswer>
     */
    Page<BbsAnswer> getAnswerPage(QuestionAnswerPage model);

    /**
     * 编辑问题回答（id存在则更新，否则新建）
     * @param model BbsAnswer
     * @return BbsAnswer
     */
    BbsAnswer editQuestionAnswer(BbsAnswer model);
}
