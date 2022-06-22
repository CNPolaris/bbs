package com.polaris.bbs.service;

import com.polaris.bbs.pojo.BbsSection;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface IBbsSectionService extends IService<BbsSection> {
    /**
     * 获取全部的标签
     * @return List<BbsSection>
     */
    List<BbsSection> getSectionAllList();
}
