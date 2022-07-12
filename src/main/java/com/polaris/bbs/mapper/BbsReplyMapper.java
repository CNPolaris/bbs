package com.polaris.bbs.mapper;

import com.polaris.bbs.dto.editor.reply.ReplySearchParam;
import com.polaris.bbs.pojo.BbsReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author polaris
 * @since 2022-06-08
 */
public interface BbsReplyMapper extends BaseMapper<BbsReply> {
    /**
     * 获取一级评论
     * @param model ReplySearchParam
     * @return List<BbsReply>
     */
    List<BbsReply> selectOneComment(ReplySearchParam model);

    /**
     * 获取二级评论
     * @param model ReplySearchParam
     * @return List<BbsReply>
     */
    List<BbsReply> selectTwoComment(ReplySearchParam model);
}
