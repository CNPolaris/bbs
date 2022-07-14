package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.editor.tutor.TutorPageQuery;
import com.polaris.bbs.pojo.BbsTutor;
import com.polaris.bbs.mapper.BbsTutorMapper;
import com.polaris.bbs.service.IBbsTutorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-07-12
 */
@Service
public class BbsTutorServiceImpl extends ServiceImpl<BbsTutorMapper, BbsTutor> implements IBbsTutorService {
    private final BbsTutorMapper tutorMapper;

    public BbsTutorServiceImpl(BbsTutorMapper tutorMapper) {
        this.tutorMapper = tutorMapper;
    }

    @Override
    public BbsTutor editTutor(BbsTutor model) {
        BbsTutor tutor;
        if (model.getId() != null) {
            tutor = getById(model.getId());
            QueryWrapper<BbsTutor> queryWrapper = new QueryWrapper<>(model);
            update(tutor, queryWrapper);
        } else {
            tutor = new BbsTutor();
            saveOrUpdate(tutor, new QueryWrapper<>(model));
        }
        return tutor;
    }

    @Override
    public Page<BbsTutor> getUserCreateTutorList(Long userId, TutorPageQuery model) {
        Page<BbsTutor> page = new Page<>(model.getPage(), model.getLimit());
        QueryWrapper<BbsTutor> queryWrapper = new QueryWrapper<>();
        if (model.getName() != null) {
            queryWrapper.eq("name", model.getName());
        }
        return tutorMapper.selectPage(page, queryWrapper.eq("create_user", userId).orderByDesc("create_time"));
    }

    @Override
    public void userDeleteTutor(Long userId, Long tutorId) {
        QueryWrapper<BbsTutor> queryWrapper = new QueryWrapper<>();
        tutorMapper.delete(queryWrapper.eq("id", tutorId).eq("create_user", userId));
    }
}
