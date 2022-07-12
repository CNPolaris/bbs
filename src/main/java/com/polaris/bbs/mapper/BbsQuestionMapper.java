package com.polaris.bbs.mapper;

import com.polaris.bbs.dto.editor.question.AnswerRequest;
import com.polaris.bbs.pojo.BbsQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
public interface BbsQuestionMapper extends BaseMapper<BbsQuestion> {
    /**
     * 清除相关的回答答案
     * @param questionId Long
     */
    void deletePersonalQuestionAnswer(Long questionId);

    /**
     * 设置答案的状态
     * @param model AnswerRequest
     */
    void setPersonalQuestionAnswerStatus(AnswerRequest model);
}
