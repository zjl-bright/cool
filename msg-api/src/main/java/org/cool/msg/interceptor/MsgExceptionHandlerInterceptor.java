/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.interceptor;

import org.cool.msg.model.Message;
import org.cool.msg.exception.MsgException;

public interface MsgExceptionHandlerInterceptor {


    default boolean whenError(Message message) throws MsgException {
        return true;
    }

}
