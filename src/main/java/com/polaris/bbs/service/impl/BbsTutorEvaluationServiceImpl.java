package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.tutor.TutorPageQuery;
import com.polaris.bbs.pojo.BbsTutorEvaluation;
import com.polaris.bbs.mapper.BbsTutorEvaluationMapper;
import com.polaris.bbs.service.IBbsTutorEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-07-12
 */
@Service
public class BbsTutorEvaluationServiceImpl extends ServiceImpl<BbsTutorEvaluationMapper, BbsTutorEvaluation> implements IBbsTutorEvaluationService {

    private final BbsTutorEvaluationMapper evaluationMapper;

    public BbsTutorEvaluationServiceImpl(BbsTutorEvaluationMapper evaluationMapper) {
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public Page<BbsTutorEvaluation> selectTutorEvaluationList(TutorPageQuery model) {
        Page<BbsTutorEvaluation> page = new Page<>(model.getPage(),model.getLimit());
        QueryWrapper<BbsTutorEvaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tutorId", model.getTutorId());
        return evaluationMapper.selectPage(page, queryWrapper);
    }
}
