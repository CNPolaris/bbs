package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.tutor.TutorPageQuery;
import com.polaris.bbs.pojo.BbsTutorEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-07-12
 */
public interface IBbsTutorEvaluationService extends IService<BbsTutorEvaluation> {
    /**
     * 获取关于导师的评价信息
     * @param model TutorPageQuery
     * @return Page<BbsTutorEvaluation>
     */
    Page<BbsTutorEvaluation> selectTutorEvaluationList(TutorPageQuery model);
}
