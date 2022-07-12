package com.polaris.bbs.common.dto;

import com.polaris.bbs.pojo.BbsTutor;
import lombok.Data;

import java.util.List;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class Response {
    private long total;
    private List<Object> list;

    public Response(long total, List<Object> list) {
        this.total = total;
        this.list = list;
    }
}
