package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.tutor.TutorPageQuery;
import com.polaris.bbs.pojo.BbsTutor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-07-12
 */
public interface IBbsTutorService extends IService<BbsTutor> {
    /**
     * 编辑或新建导师推荐信息
     * id存在则更新 id不存在则新建
     * @param model BbsTutor
     * @return BbsTutor
     */
    BbsTutor editTutor(BbsTutor model);

    /**
     * 用户获取个人发布的导师推荐信息
     * @param userId Long
     * @param model TutorPageQuery
     * @return  Page<BbsTutor>
     */
    Page<BbsTutor> getUserCreateTutorList(Long userId, TutorPageQuery model);
}
