package org.cool.msg.interceptor;

import org.cool.msg.model.Message;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;

import java.io.Serializable;
import java.util.Map;

public interface MsgTemplateHandlerInterceptor {

    String getSuffix();

    String applyTemplate(String templateName, Map<String, Serializable> context) throws MsgException;
}
