package com.polaris.bbs.dto.editor.tutor;

import lombok.Data;

import java.util.Date;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class TutorEditResponse {
    private Long id;
    private Long createUser;
    private String createUserAvatar;
    private String name;
    private String university;
    private String college;
    private String research;
    private String evaluation;
    private Integer status;
    private Date createTime;
}
