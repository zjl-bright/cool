/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.handler.validator;

import org.cool.msg.enums.MsgChannel;
import org.cool.msg.interceptor.MsgValidatorHandlerInterceptor;
import org.cool.msg.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoticeValidatorHandlerInterceptor implements MsgValidatorHandlerInterceptor {

    public MsgChannel getMsgChannel(){
        return MsgChannel.Notice;
    }

    public void check(Message message){

    }
}
