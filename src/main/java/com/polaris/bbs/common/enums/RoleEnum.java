package com.polaris.bbs.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
    Admin(1,"admin"),
    User(2,"user");
    Long code;
    String name;
    RoleEnum(int code, String name) {
        this.code = Long.valueOf(code);
        this.name = name;
    }


    private static final Map<Long, RoleEnum> KEY_MAP = new HashMap<>();

    static {
        for (RoleEnum item : RoleEnum.values()) {
            KEY_MAP.put(item.getCode(), item);
        }
    }
    public static RoleEnum fromCode(Integer code) {
        return KEY_MAP.get(code);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
