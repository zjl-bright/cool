/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg;

import org.hsb.cool.spring.msg.enums.MsgChannel;
import org.hsb.cool.spring.msg.exception.MsgException;
import org.hsb.cool.spring.msg.model.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MsgService {

    void initial(List<String> receivers, String title, MsgChannel channel, String templateName, Map<String, Serializable> context) throws MsgException;

    void initial(List<String> receivers, String title, MsgChannel channel, String templateContent, Map<String, Serializable> context, LocalDateTime createTime) throws MsgException;

    void initial(List<String> receivers, String title, MsgChannel channel, String templateContent, Map<String, Serializable> context, LocalDateTime createTime, Map<String, Object> parameter) throws MsgException;

    void send(Message msg) throws MsgException;
}
