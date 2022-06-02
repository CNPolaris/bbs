package com.polaris.bbs.dto.user;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class UserInfoResponse {
    private Long id;
    private String userName;
    private String realName;
    private String avatar;
    private String role;
    private Long roleId;
}
