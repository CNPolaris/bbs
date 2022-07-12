package com.polaris.bbs.dto.editor.question;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class QuestionPage {
    private Integer page;
    private Integer limit;
    private Integer sectionId;
    private String title;
    private Integer status;
}
