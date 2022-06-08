package com.polaris.bbs.dto.reply;

import com.polaris.bbs.pojo.BbsReply;
import lombok.Data;

import java.util.List;

/**
 * @author CNPolaris
 * @version 1.0
 */
@Data
public class ReplyResponse {
    private ReplyFloor comment;
    private List<ReplyFloor> replyList;
    private long total;
}
