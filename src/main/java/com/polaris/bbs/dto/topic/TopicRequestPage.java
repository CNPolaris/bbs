package com.polaris.bbs.dto.topic;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class TopicRequestPage {
    private Integer page;
    private Integer limit;
    private Integer sectionId;
}
