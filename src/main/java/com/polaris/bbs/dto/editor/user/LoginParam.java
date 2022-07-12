package com.polaris.bbs.dto.editor.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class LoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
