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
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bbs_tutor")
@ApiModel(value="BbsTutor对象", description="")
public class BbsTutor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "导师姓名")
    private String name;

    @ApiModelProperty(value = "高校")
    private String university;

    @ApiModelProperty(value = "学院")
    private String college;

    @ApiModelProperty(value = "研究方向")
    private String research;

    @ApiModelProperty(value = "评价")
    private String evaluation;

    @ApiModelProperty(value = "有效状态")
    private Integer status;

    @ApiModelProperty(value = "添加时间")
    private Date createTime;

    @ApiModelProperty(value = "推荐人")
    private String createUser;
}
