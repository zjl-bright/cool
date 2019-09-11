/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.handler.validator;

import org.cool.msg.exception.MsgException;
import org.cool.msg.interceptor.MsgPreValidatorHandlerInterceptor;
import org.cool.msg.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Slf4j
@Component
public class PreValidatorHandlerInterceptor implements MsgPreValidatorHandlerInterceptor {

    @Override
    public void check(Message message) throws MsgException{
        if (Objects.isNull(message.getChannel())) {

            throw new MsgException("message.channel.required");

        } else if (CollectionUtils.isEmpty(message.getReceiver())) {

            throw new MsgException("message.receiver.required");

        } else if (!StringUtils.hasText(message.getContent())) {

            throw new MsgException("message.template.or.content.required.one");
        }
    }
}
