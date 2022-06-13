package com.polaris.bbs.dto.reply;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
@ApiModel(value = "评论获取参数")
public class ReplySearchParam {
    @ApiModelProperty(value = "评论的文章")
    private Long topicId;
    @ApiModelProperty(value = "评论级别 1.一级评论 2.二级评论")
    private Integer commentLevel;
    @ApiModelProperty(value = "父级评论Id")
    private Long parentCommentId;
    @ApiModelProperty(value = "页数")
    private Integer page;
    @ApiModelProperty(value = "评论数量")
    private Integer limit;
    @ApiModelProperty(value = "二级评论页数")
    private Integer twoPage;
    @ApiModelProperty(value = "二级评论数量")
    private Integer twoLimit;
}
