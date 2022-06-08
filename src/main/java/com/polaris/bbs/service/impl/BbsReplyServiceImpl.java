package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.enums.CommentEnum;
import com.polaris.bbs.common.utils.StringUtils;
import com.polaris.bbs.dto.reply.ReplySearchParam;
import com.polaris.bbs.pojo.BbsReply;
import com.polaris.bbs.mapper.BbsReplyMapper;
import com.polaris.bbs.service.IBbsReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-06-08
 */
@Service
public class BbsReplyServiceImpl extends ServiceImpl<BbsReplyMapper, BbsReply> implements IBbsReplyService {
    private final BbsReplyMapper replyMapper;

    public BbsReplyServiceImpl(BbsReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public BbsReply createComment(Long userId, BbsReply model, HttpServletRequest request) {
        String ip = StringUtils.getIp(request);
        String address = StringUtils.getCityInfo(ip);
        // 记录ip信息
        BbsReply bbsReply = new BbsReply();
        bbsReply.setIp(ip);
        bbsReply.setAddress(address);
        // 保存评论信息
        bbsReply.setCreateUser(userId);
        bbsReply.setContent(model.getContent());
        bbsReply.setTopicId(model.getTopicId());
        bbsReply.setTitle(model.getTitle());
        bbsReply.setCreateTime(new Date());
        // 如果父级评论不存在
        if(model.getParentCommentId()==null)
        {
            bbsReply.setCommentLevel(CommentEnum.ONE.getCode());
            bbsReply.setParentCommentId(null);
        } else {
            // 如果父级评论存在
            bbsReply.setCommentLevel(CommentEnum.TWO.getCode());
            bbsReply.setParentCommentId(model.getParentCommentId());
        }
        save(bbsReply);
        return bbsReply;
    }

    @Override
    public Page<BbsReply> selectCommentList(ReplySearchParam model) {
        Page<BbsReply> page = new Page<>(model.getPage(), model.getLimit());
        QueryWrapper<BbsReply> bbsReplyQueryWrapper = new QueryWrapper<>();
        bbsReplyQueryWrapper.eq("topic_id", model.getTopicId());
        bbsReplyQueryWrapper.eq("comment_level", CommentEnum.ONE.getCode());
        return replyMapper.selectPage(page, bbsReplyQueryWrapper);
    }

    @Override
    public Page<BbsReply> selectTwoCommentList(ReplySearchParam model) {
        Page<BbsReply> page = new Page<>(model.getTwoPage(), model.getTwoLimit());
        QueryWrapper<BbsReply> bbsReplyQueryWrapper = new QueryWrapper<>();
        bbsReplyQueryWrapper.eq("topic_id", model.getTopicId());
        bbsReplyQueryWrapper.eq("comment_level", CommentEnum.TWO.getCode());
        bbsReplyQueryWrapper.eq("parent_comment_id", model.getParentCommentId());
        return replyMapper.selectPage(page, bbsReplyQueryWrapper);
    }
}
