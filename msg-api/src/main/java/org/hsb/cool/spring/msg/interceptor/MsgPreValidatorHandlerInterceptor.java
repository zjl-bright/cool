/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.interceptor;

import org.hsb.cool.spring.msg.exception.MsgException;
import org.hsb.cool.spring.msg.model.Message;

public interface MsgPreValidatorHandlerInterceptor {

    void check(Message message) throws MsgException;
}
