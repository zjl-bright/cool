/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.interceptor;

import org.hsb.cool.spring.msg.model.Message;
import org.hsb.cool.spring.msg.enums.MsgChannel;
import org.hsb.cool.spring.msg.exception.MsgException;

public interface MsgHandlerInterceptor {

    MsgChannel getMsgChannel();

    void preHandler(Message message) throws MsgException;

//    default Message postHandler(Message message) throws MsgException{
//        return message;
//    }
//
//    default void whenError(Message message) throws MsgException{
//
//    }

}
