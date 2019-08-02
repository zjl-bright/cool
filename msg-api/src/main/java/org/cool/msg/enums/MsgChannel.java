package org.cool.msg.enums;

import java.util.Objects;

public enum MsgChannel {
    Unknown(-1, "未知消息渠道"),
    Notice(0, "站内信"),
    Sms(1, "短信"),
    Email(2, "邮件"),
    AppPush(3, "APP推送消息");

    private final int value;
    private final String desc;

    MsgChannel(int number, String desc) {
        this.value = number;
        this.desc = desc;
    }

    public static MsgChannel from(int value) {
        MsgChannel[] channels = values();
        int length = channels.length;

        for(int index = 0; index < length; ++index) {
            MsgChannel range = channels[index];
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
