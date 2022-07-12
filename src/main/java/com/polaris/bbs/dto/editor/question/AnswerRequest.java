package com.polaris.bbs.dto.editor.question;

import lombok.Data;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class AnswerRequest {
    private Long questionId;
    private Long answerId;
    /**
     * 状态（0：无效 1：有效 2：暂定）
     */
    private Integer status;
}
