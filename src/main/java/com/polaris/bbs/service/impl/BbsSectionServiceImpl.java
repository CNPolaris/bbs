package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.bbs.common.enums.StatusEnum;
import com.polaris.bbs.pojo.BbsSection;
import com.polaris.bbs.mapper.BbsSectionMapper;
import com.polaris.bbs.service.IBbsSectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Service
public class BbsSectionServiceImpl extends ServiceImpl<BbsSectionMapper, BbsSection> implements IBbsSectionService {

    private final BbsSectionMapper sectionMapper;

    public BbsSectionServiceImpl(BbsSectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    @Override
    public List<BbsSection> getSectionAllList() {
        return sectionMapper.selectList(new QueryWrapper<BbsSection>().eq("status", StatusEnum.OK.getCode()));
    }
}
