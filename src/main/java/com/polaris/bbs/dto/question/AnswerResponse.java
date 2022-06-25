package com.polaris.bbs.dto.question;

import lombok.Data;

import java.util.Date;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class AnswerResponse {
    private Long id;
    private Long questionId;
    private Long createUser;
    private String avatar;
    private String nickName;
    private String content;
    private Date createTime;
}
