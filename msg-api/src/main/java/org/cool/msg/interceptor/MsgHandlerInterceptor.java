/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.interceptor;

import org.cool.msg.model.Message;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;

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
