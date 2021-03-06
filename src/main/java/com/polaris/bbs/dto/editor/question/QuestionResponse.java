package com.polaris.bbs.dto.editor.question;

import lombok.Data;

import java.util.Date;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class QuestionResponse {
    private Long id;

    private String nickName;

    private String avatar;

    private String section;

    private Integer replyCount;

    private Integer readCount;

    private Integer answerCount;

    private String title;

    private String content;

    private Integer status;

    private Date createTime;

    private String tags;
}
