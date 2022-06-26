package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.enums.StatusEnum;
import com.polaris.bbs.dto.question.QuestionPage;
import com.polaris.bbs.pojo.BbsQuestion;
import com.polaris.bbs.mapper.BbsQuestionMapper;
import com.polaris.bbs.service.IBbsQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-06-25
 */
@Service
public class BbsQuestionServiceImpl extends ServiceImpl<BbsQuestionMapper, BbsQuestion> implements IBbsQuestionService {

    private final BbsQuestionMapper questionMapper;

    public BbsQuestionServiceImpl(BbsQuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }


    @Override
    public BbsQuestion editQuestion(Long userId, BbsQuestion model, HttpServletRequest request) {
        // id不存在 则插入数据
        if(model.getId() == null){
            BbsQuestion bbsQuestion = new BbsQuestion();
            bbsQuestion.setCreateUser(userId);
            bbsQuestion.setSectionId(model.getSectionId());
            bbsQuestion.setTitle(model.getTitle());
            bbsQuestion.setContent(model.getContent());
            bbsQuestion.setCreateTime(new Date());
            // 状态信息初始化
            bbsQuestion.setReadCount(0);
            bbsQuestion.setReplyCount(0);
            bbsQuestion.setAnswerCount(0);
            bbsQuestion.setStatus(StatusEnum.OK.getCode());
            save(bbsQuestion);
            return bbsQuestion;
        } else {
            BbsQuestion question = getById(model.getId());
            question.setTitle(model.getTitle());
            question.setContent(model.getContent());
            question.setStatus(model.getStatus());
            question.setSectionId(model.getSectionId());
            updateById(question);
            return question;
        }
    }

    @Override
    public Page<BbsQuestion> getQuestionPage(QuestionPage model) {
        Page<BbsQuestion> page = new Page<>(model.getPage(), model.getLimit());

        QueryWrapper<BbsQuestion> queryWrapper = new QueryWrapper<>();
        if(model.getSectionId()!=null){
            queryWrapper.eq("section_id", model.getSectionId());
        } else if(model.getTitle()!=null){
            queryWrapper.eq("title", model.getTitle());
        } else if(model.getStatus()!=null) {
            queryWrapper.eq("status", model.getStatus());
        }
        return questionMapper.selectPage(page, queryWrapper.orderByDesc("create_time"));
    }
}
