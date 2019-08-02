package org.cool.msg.interceptor;


import org.cool.msg.enums.MsgChannel;
import org.cool.msg.model.Message;
import org.cool.msg.exception.MsgException;

public interface MsgValidatorHandlerInterceptor {

    MsgChannel getMsgChannel();

    void check(Message message) throws MsgException;
}
