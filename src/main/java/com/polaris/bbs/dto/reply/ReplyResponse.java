package com.polaris.bbs.dto.reply;

import com.polaris.bbs.pojo.BbsReply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
@ApiModel(value = "多级评论响应实体")
public class ReplyResponse {
    @ApiModelProperty(value = "多级评论")
    private ReplyFloor comment;
    @ApiModelProperty(value = "二级评论")
    private List<ReplyFloor> replyList;
    @ApiModelProperty(value = "二级评论总数")
    private long total;
}
