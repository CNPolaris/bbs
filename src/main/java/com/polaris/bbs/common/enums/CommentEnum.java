package com.polaris.bbs.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CNPolaris
 * @version 1.0
 */
public enum CommentEnum {
    ONE(1, "一级评论"),
    TWO(2,"二级评论");

    int code;
    String name;

    CommentEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, CommentEnum> KEY_MAP = new HashMap<>();
    static {
        for (CommentEnum item : CommentEnum.values()) {
            KEY_MAP.put(item.getCode(), item);
        }
    }
    public static CommentEnum fromCode(Integer code) {
        return KEY_MAP.get(code);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
