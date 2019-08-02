package org.cool.msg.handler.validator;

import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import org.cool.msg.interceptor.MsgValidatorHandlerInterceptor;
import org.cool.msg.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SmsValidatorHandlerInterceptor implements MsgValidatorHandlerInterceptor {

    public MsgChannel getMsgChannel(){
        return MsgChannel.Sms;
    }

    public void check(Message message) throws MsgException {
        List<String> mobiles = message.getReceiver();

        for(String mobile : mobiles){
            if(CommonPattern.MOBILE.invalid(mobile)){
                log.error("SmsValidatorHandlerInterceptor failed, receivers={}", message.getReceiver());
                throw new MsgException("message.receiver.mobile.invalid");
            }
        }
    }
}
