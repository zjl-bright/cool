package org.cool.msg.enums;

import java.util.Objects;

public enum LogType {
    SL4J(0, "日志文件"),
    DB(1, "数据库表");

    private final int value;
    private final String desc;

    LogType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LogType from(int value) {
        LogType[] types = values();
        int length = types.length;

        for(int index = 0; index < length; ++index) {
            LogType range = types[index];
            if (Objects.equals(range.value, value)) {
                return range;
            }
        }

        return null;
    }

    public int value() {
        return this.value;
    }

    public String toString() {
        return this.desc;
    }
}
