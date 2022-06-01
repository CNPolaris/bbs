package com.polaris.bbs.mapper;

import com.polaris.bbs.dto.topic.TopicEdit;
import com.polaris.bbs.pojo.BbsTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
public interface BbsTopicMapper extends BaseMapper<BbsTopic> {
    /**
     * 更新
     * @param model TopicEdit
     * @return BbsTopic
     */
    BbsTopic updateTopic(TopicEdit model);
}
