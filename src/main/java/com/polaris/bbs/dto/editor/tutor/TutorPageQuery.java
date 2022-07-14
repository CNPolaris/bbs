package com.polaris.bbs.dto.editor.tutor;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class TutorPageQuery {
    private Integer page;
    private Integer limit;
    private String name;
    private Integer status;
    private Long tutorId;
}
