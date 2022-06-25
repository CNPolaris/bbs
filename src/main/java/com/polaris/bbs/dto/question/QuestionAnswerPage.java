package com.polaris.bbs.dto.question;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class QuestionAnswerPage {
    private Long questionId;
    private Integer page;
    private Integer limit;
}
