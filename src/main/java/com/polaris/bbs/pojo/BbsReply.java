package com.polaris.bbs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author polaris
 * @since 2022-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bbs_reply")
@ApiModel(value="BbsReply对象", description="")
public class BbsReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "评论的文章ID")
    private Long topicId;

    @ApiModelProperty(value = "评论人ID")
    private Long createUser;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    @ApiModelProperty(value = "父级评论ID")
    private Long parentCommentId;

    @ApiModelProperty(value = "父级评论的用户ID")
    private Long parentCommentUserId;

    @ApiModelProperty(value = "被回复的评论id")
    private Long replyCommentId;

    @ApiModelProperty(value = "被回复的评论的用户ID")
    private Long replyCommentUserId;

    @ApiModelProperty(value = "评论级别")
    private Integer commentLevel;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "地址")
    private String address;


}
