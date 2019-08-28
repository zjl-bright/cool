package org.cool.msg;

import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import org.cool.msg.model.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MsgService {

    void initial(List<String> receivers, String title, MsgChannel channel, String templateName, Map<String, Serializable> context) throws MsgException;

    void initial(List<String> receivers, String title, MsgChannel channel, String templateContent, Map<String, Serializable> context, LocalDateTime createTime) throws MsgException;

    void send(Message msg) throws MsgException;
}
