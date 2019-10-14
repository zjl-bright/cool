/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.interceptor;


import org.cool.msg.exception.MsgException;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.model.Message;

public interface MsgValidatorHandlerInterceptor {

    MsgChannel getMsgChannel();

    void check(Message message) throws MsgException;
}
