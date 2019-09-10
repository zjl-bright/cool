package org.cool.common.enums;

public enum Status {

    DELETED("已删除", -1),

    DISABLED("已禁用，未激活，无效，不是", 0),

    ENABLED("已启用, 已激活, 有效, 是", 1);

    private String describe;

    private Integer value;

    Status(String describe, Integer value) {
        this.describe = describe;
        this.value = value;
    }

    public Integer value() {
        return value;
    }

}
