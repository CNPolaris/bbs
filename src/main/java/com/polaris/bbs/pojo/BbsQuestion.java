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
 * @since 2022-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bbs_question")
@ApiModel(value="BbsQuestion对象", description="")
public class BbsQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标签")
    private Long sectionId;

    @ApiModelProperty(value = "创建者")
    private Long createUser;

    @ApiModelProperty(value = "点击量")
    private Integer readCount;

    @ApiModelProperty(value = "评论量")
    private Integer replyCount;

    @ApiModelProperty(value = "回答量")
    private Integer answerCount;

    @ApiModelProperty(value = "发布时间")
    private Date createTime;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "有效状态")
    private Integer status;

    @ApiModelProperty(value = "标签")
    private String tags;
}
