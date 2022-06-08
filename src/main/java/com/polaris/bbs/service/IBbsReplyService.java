package com.polaris.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.dto.reply.ReplySearchParam;
import com.polaris.bbs.pojo.BbsReply;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author polaris
 * @since 2022-06-08
 */
public interface IBbsReplyService extends IService<BbsReply> {
    /**
     * 发表评论
     * @param userId Long
     * @param model BbsReply
     * @param request HttpServletRequest
     * @return BbsReply
     */
    BbsReply createComment(Long userId, BbsReply model, HttpServletRequest request);

    /**
     * 获取评论列表
     * @param model ReplySearchParam
     * @return Page<BbsReply>
     */
    Page<BbsReply> selectCommentList(ReplySearchParam model);

    Page<BbsReply> selectTwoCommentList(ReplySearchParam model);
}
