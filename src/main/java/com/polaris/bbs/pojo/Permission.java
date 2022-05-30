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
 * 权限表
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
@ApiModel(value="Permission对象", description="权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "权限名")
    private String name;

    @ApiModelProperty(value = "资源定位符")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "状态(0.有效 1.无效)")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
