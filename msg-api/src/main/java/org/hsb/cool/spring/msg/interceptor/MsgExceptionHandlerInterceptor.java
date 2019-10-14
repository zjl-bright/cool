/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.interceptor;

import org.hsb.cool.spring.msg.model.Message;
import org.hsb.cool.spring.msg.exception.MsgException;

public interface MsgExceptionHandlerInterceptor {


    default boolean whenError(Message message) throws MsgException {
        return true;
    }

}
