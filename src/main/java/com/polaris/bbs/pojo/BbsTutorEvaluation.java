package com.polaris.bbs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bbs_tutor_evaluation")
@ApiModel(value="BbsTutorEvaluation对象", description="")
public class BbsTutorEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "对应导师Id")
    private Long tutorId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布人")
    private Long createUser;

    @ApiModelProperty(value = "发布时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "父级评论")
    private Long parentCommentId;

    @ApiModelProperty(value = "评论级别")
    private Integer commentLevel;

    @ApiModelProperty(value = "有效状态")
    private Integer status;


}
