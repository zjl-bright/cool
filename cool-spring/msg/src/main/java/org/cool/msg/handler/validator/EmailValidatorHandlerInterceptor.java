/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.handler.validator;

import lombok.extern.slf4j.Slf4j;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import org.cool.msg.interceptor.MsgValidatorHandlerInterceptor;
import org.cool.msg.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EmailValidatorHandlerInterceptor implements MsgValidatorHandlerInterceptor {

    @Override
    public MsgChannel getMsgChannel(){
        return MsgChannel.Email;
    }

    @Override
    public void check(Message message) {
        List<String> emails = message.getReceiver();

        for(String email : emails){
            if(CommonPattern.EMAIL.invalid(email)){
                log.error("EmailValidatorHandlerInterceptor failed, receivers={}", message.getReceiver());
                throw new MsgException("message.receiver.email.invalid");
            }
        }
    }
}
