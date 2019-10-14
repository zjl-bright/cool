/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.interceptor;

import org.hsb.cool.spring.msg.exception.MsgException;

import java.io.Serializable;
import java.util.Map;

public interface MsgTemplateHandlerInterceptor {

    String getSuffix();

    String applyTemplate(String templateName, Map<String, Serializable> context) throws MsgException;
}
