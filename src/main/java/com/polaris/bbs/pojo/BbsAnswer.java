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
@TableName("bbs_answer")
@ApiModel(value="BbsAnswer对象", description="")
public class BbsAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "问题主键")
    private Long questionId;

    @ApiModelProperty(value = "回答者")
    private Long createUser;

    @ApiModelProperty(value = "回答内容")
    private String content;

    @ApiModelProperty(value = "回答时间")
    private Date createTime;


}
