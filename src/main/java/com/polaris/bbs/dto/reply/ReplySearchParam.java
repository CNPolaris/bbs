package com.polaris.bbs.dto.reply;


import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class ReplySearchParam {
    private Long topicId;
    private Integer commentLevel;
    private Long parentCommentId;
    private Integer page;
    private Integer limit;

    private Integer twoPage;
    private Integer twoLimit;
}
