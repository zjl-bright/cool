/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class Message implements Serializable {

    private List<String> receiver;

    private String title;

    private String content;

    private Integer channel;

    private String failReason;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 消息发送时间
     */
    private LocalDateTime eventCreateTime;

    /**
     * 消息参数
     */
    Map<String, Object> parameter;

    public enum Status {
        Initial(0, "开始消费消息"),
        SendSuccess(1, "消息发送成功"),
        SendFailed(-1, "消息发送失败"),
        Closed(2, "关闭"),
        InitialFailed(-2, "初始化消息失败");

        private final int value;
        private final String desc;

        Status(int number, String desc) {
            this.value = number;
            this.desc = desc;
        }

        public static Message.Status from(int value) {
            Message.Status[] statuses = values();
            int length = statuses.length;

            for(int index = 0; index < length; ++index) {
                Message.Status status = statuses[index];
                if (Objects.equals(status.value, value)) {
                    return status;
                }
            }

            return null;
        }

        public int value() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.desc;
        }

        public static Boolean canChange(Integer from, Integer to) {
            return from < to || to < 0;
        }
    }
}
