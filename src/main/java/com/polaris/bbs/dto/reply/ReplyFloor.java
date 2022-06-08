package com.polaris.bbs.dto.reply;

import lombok.Data;

import java.util.Date;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class ReplyFloor {
    private Long id;

    private Long topicId;

    private Long createUser;

    private String avatar;

    private String nickName;

    private String title;

    private String content;

    private Date createTime;

    private Long parentCommentId;

    private Long parentCommentUserId;

    private Long replyCommentId;

    private Long replyCommentUserId;

    private Integer commentLevel;

    private String ip;

    private String address;
}
