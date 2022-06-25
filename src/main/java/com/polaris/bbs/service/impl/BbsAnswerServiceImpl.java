package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.question.QuestionAnswerPage;
import com.polaris.bbs.pojo.BbsAnswer;
import com.polaris.bbs.mapper.BbsAnswerMapper;
import com.polaris.bbs.service.IBbsAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
@Service
public class BbsAnswerServiceImpl extends ServiceImpl<BbsAnswerMapper, BbsAnswer> implements IBbsAnswerService {
    private final BbsAnswerMapper answerMapper;

    public BbsAnswerServiceImpl(BbsAnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public Page<BbsAnswer> getAnswerPage(QuestionAnswerPage model) {
        Page<BbsAnswer> page = new Page<>(model.getPage(), model.getLimit());

        return answerMapper.selectPage(page,new QueryWrapper<BbsAnswer>().eq("question_id", model.getQuestionId()));
    }
}
