/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg;

import org.cool.msg.interceptor.*;
import org.cool.msg.model.Message;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import lombok.extern.slf4j.Slf4j;
import org.cool.msg.util.TemplateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class MsgServiceImpl implements MsgService {

    private final MsgPreValidatorHandlerInterceptor preValidatorHandlerInterceptor;

    private final ApplicationContext applicationContext;

    public MsgServiceImpl(ApplicationContext applicationContext, MsgPreValidatorHandlerInterceptor preValidatorHandlerInterceptor) {
        this.applicationContext = applicationContext;
        this.preValidatorHandlerInterceptor = preValidatorHandlerInterceptor;
    }

    @Override
    public void initial(List<String> receiver, String title, MsgChannel channel, String templateName, Map<String, Serializable> context) {
        Message message = new Message();
        if (StringUtils.hasText(templateName)) {
            Map<String, MsgTemplateHandlerInterceptor> msgTemplateHandlerInterceptorMap = applicationContext.getBeansOfType(MsgTemplateHandlerInterceptor.class);
            if (!CollectionUtils.isEmpty(msgTemplateHandlerInterceptorMap)) {
                msgTemplateHandlerInterceptorMap.values().forEach(msgTemplateHandlerInterceptor -> {
                    if ( templateName.contains(msgTemplateHandlerInterceptor.getSuffix())) {
                        message.setContent(msgTemplateHandlerInterceptor.applyTemplate(templateName, context));
                    }
                });
            }
        }
        message.setReceiver(receiver).setTitle(title).setChannel(channel.value()).setStatus(Message.Status.Initial.value());
        send(message);
    }

    @Override
    public void initial(List<String> receiver, String title, MsgChannel channel, String templateContent, Map<String, Serializable> context, LocalDateTime createTime) {
        Message message = new Message();
        String content = TemplateUtil.render(templateContent, context);
        message.setReceiver(receiver).setTitle(title).setChannel(channel.value()).setContent(content)
                .setEventCreateTime(createTime).setStatus(Message.Status.Initial.value());
        send(message);
    }

    @Override
    public void send(Message message) {

        MsgChannel msgChannel = MsgChannel.from(message.getChannel());
        try {
            preValidatorHandlerInterceptor.check(message);

            Map<String, MsgValidatorHandlerInterceptor> messageValidatorMap = applicationContext.getBeansOfType(MsgValidatorHandlerInterceptor.class);
            if (!CollectionUtils.isEmpty(messageValidatorMap)) {
                messageValidatorMap.values().forEach(messageValidator -> {
                    if (Objects.equals(messageValidator.getMsgChannel(), msgChannel)) {
                        messageValidator.check(message);
                    }
                });
            }



            Map<String, MsgHandlerInterceptor> msgHandlerInterceptorMap = applicationContext.getBeansOfType(MsgHandlerInterceptor.class);
            if (!CollectionUtils.isEmpty(msgHandlerInterceptorMap)) {
                msgHandlerInterceptorMap.values().forEach(msgHandlerInterceptor -> {
                    if (Objects.equals(msgHandlerInterceptor.getMsgChannel(), msgChannel)) {
                        msgHandlerInterceptor.preHandler(message);
                    }
                });
            }
            doSendMessage(message, msgChannel);
        } catch (Exception e){
            MsgExceptionHandlerInterceptor exceptionHandlerInterceptor = applicationContext.getBean(MsgExceptionHandlerInterceptor.class);
            if (Objects.nonNull(exceptionHandlerInterceptor)) {
                exceptionHandlerInterceptor.whenError(message);
            }
            return;
        }
    }

    private void doSendMessage(Message message, MsgChannel msgChannel) {

        StringBuilder sbFail = new StringBuilder();
        Boolean flag = true;

        Map<String, MsgSendService> msgServiceMap = applicationContext.getBeansOfType(MsgSendService.class);
        if (!CollectionUtils.isEmpty(msgServiceMap)) {
            for(MsgSendService msgSendService : msgServiceMap.values()){
                if (Objects.equals(msgSendService.getMsgChannel(), msgChannel)) {
                    try {
                        msgSendService.send(message);
                    } catch (Exception e) {
                        String error = e.getMessage();
                        sbFail.append(error).append("\n");
                        flag = false;
                    }

                }
            }
        }
        String failResult = sbFail.toString().trim();
        if (flag) {
            message.setStatus(Message.Status.SendSuccess.value());
        } else {
            message.setStatus(Message.Status.SendFailed.value()).setFailReason(failResult);
        }

        if (!flag) {
            throw new MsgException(failResult);
        }
    }
}
