package com.polaris.bbs.dto.user;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class UserRegisterParam {
    private String userName;
    private String passwordOne;
    private String passwordTwo;

}
