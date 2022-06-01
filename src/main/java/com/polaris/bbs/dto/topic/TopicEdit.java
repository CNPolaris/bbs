package com.polaris.bbs.dto.topic;

import lombok.Data;

import java.util.Date;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class TopicEdit {
    private Long id;

    private Long sectionId;

    private Long createUser;

    private Integer replyCount;

    private Integer readCount;

    private String title;

    private String content;

    private Integer status;

    private Date createTime;
}
