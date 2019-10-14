/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.interceptor;


import org.hsb.cool.spring.msg.enums.MsgChannel;
import org.hsb.cool.spring.msg.model.Message;
import org.hsb.cool.spring.msg.exception.MsgException;

public interface MsgValidatorHandlerInterceptor {

    MsgChannel getMsgChannel();

    void check(Message message) throws MsgException;
}
