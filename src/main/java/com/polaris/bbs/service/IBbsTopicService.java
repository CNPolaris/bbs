package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.topic.TopicEdit;
import com.polaris.bbs.dto.topic.TopicRequestPage;
import com.polaris.bbs.pojo.BbsTopic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface IBbsTopicService extends IService<BbsTopic> {
    /**
     * 分页查询帖子
     * @param model TopicRequestPage
     * @return Page<BbsTopic>
     */
    Page<BbsTopic> getTopicPage(TopicRequestPage model);

    /**
     * 编辑帖子
     * @param userId Long
     * @param model TopicEdit
     * @return BbsTopic
     */
    BbsTopic editTopic(Long userId,TopicEdit model);
}
