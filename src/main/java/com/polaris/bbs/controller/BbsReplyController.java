package com.polaris.bbs.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.dto.RespBean;
import com.polaris.bbs.dto.reply.ReplyFloor;
import com.polaris.bbs.dto.reply.ReplyResponse;
import com.polaris.bbs.dto.reply.ReplySearchParam;
import com.polaris.bbs.pojo.BbsReply;
import com.polaris.bbs.pojo.BbsUser;
import com.polaris.bbs.service.IBbsReplyService;
import com.polaris.bbs.service.IBbsUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@RestController
@RequestMapping("/api/bbs/reply")
public class BbsReplyController {
    private final IBbsUserService userService;
    private final IBbsReplyService replyService;

    public BbsReplyController(IBbsUserService userService, IBbsReplyService replyService) {
        this.userService = userService;
        this.replyService = replyService;
    }
    @ApiOperation(value = "发表评论")
    @PostMapping("/comment")
    public RespBean addComment(Principal principal, @RequestBody BbsReply model, HttpServletRequest request) {
        BbsUser bbsUser = userService.selectUserByUserName(principal.getName());
        BbsReply comment = replyService.createComment(bbsUser.getId(), model, request);
        return RespBean.success(comment);
    }

    @ApiOperation("获取评论")
    @PostMapping("/comment/list")
    public RespBean getCommentList(@RequestBody ReplySearchParam model){
        ArrayList<ReplyResponse> responses = new ArrayList<>(model.getLimit());

        Page<BbsReply> bbsReplyPage = replyService.selectCommentList(model);
        bbsReplyPage.getRecords().forEach(reply -> {
            ReplyResponse response = new ReplyResponse();
            // 一级评论
            ReplyFloor replyOne = BeanUtil.copyProperties(reply, ReplyFloor.class);
            BbsUser user = userService.getById(reply.getCreateUser());
            replyOne.setAvatar(user.getAvatar());
            replyOne.setNickName(user.getNickName());
            response.setComment(replyOne);
            model.setParentCommentId(reply.getId());
            // 二级评论
            Page<BbsReply> twoCommentList = replyService.selectTwoCommentList(model);
            List<ReplyFloor> twoList = new ArrayList<>();
            twoCommentList.getRecords().forEach(comment -> {
                ReplyFloor two = BeanUtil.copyProperties(comment, ReplyFloor.class);
                BbsUser twoUser = userService.getById(comment.getCreateUser());
                two.setAvatar(twoUser.getAvatar());
                two.setNickName(twoUser.getNickName());
                twoList.add(two);
            });
            response.setTotal(twoCommentList.getTotal());
            response.setReplyList(twoList);
            responses.add(response);
        });
        Map<String, Object> map = new HashMap<>(2);
        map.put("total", bbsReplyPage.getTotal());
        map.put("list", responses);
        return RespBean.success(map);
    }

    @ApiOperation("展开获取更多评论")
    @PostMapping("/comment/more")
    public RespBean getMoreCommentList(@RequestBody ReplySearchParam model) {
        // 更多的二级评论
        Page<BbsReply> twoCommentList = replyService.selectTwoCommentList(model);
        if(twoCommentList.getRecords().size() == 0) {
            return RespBean.error("评论到底了！");
        }
        List<ReplyFloor> twoList = new ArrayList<>();
        twoCommentList.getRecords().forEach(comment -> {
            ReplyFloor two = BeanUtil.copyProperties(comment, ReplyFloor.class);
            BbsUser twoUser = userService.getById(comment.getCreateUser());
            two.setAvatar(twoUser.getAvatar());
            two.setNickName(twoUser.getNickName());
            twoList.add(two);
        });
        return RespBean.success(twoList);
    }
}
