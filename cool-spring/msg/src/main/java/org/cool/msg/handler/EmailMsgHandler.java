package org.cool.msg.handler;/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
//package org.cool.msg.handler;
//
//import org.cool.msg.model.Message;
//import org.cool.msg.enums.MsgChannel;
//import org.cool.msg.interceptor.MsgHandlerInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class EmailMsgHandler implements MsgHandlerInterceptor {
//
//
//    public MsgChannel getMsgChannel(){
//        return MsgChannel.Email;
//    }
//
//    public void preHandler(Message message){
//
//
//    }
////    private MessagePreHandler messagePreHandler;
////
////    @Autowired
////    private MessagePostHandler messagePostHandler;
////
////
////
////    @RpcConsumer
////    private MessageWriteService messageWriteService;
////
////    @Value("${msg.log.db.enable:false}")
////    private Boolean dbLog;
////
////    private List<MsgValidatorHandlerInterceptor> validators;
////
////    @Autowired
////    public DefaultMsgSendRequestSendHandler(){
////        this.validators = new ArrayList<MsgValidatorHandlerInterceptor>();
////        this.validators.add(new PreMesssageValidator());
////        this.validators.add(new EmailValidatorHandlerInterceptor());
////        this.validators.add(new SmsValidatorHandlerInterceptor());
////        this.validators.add(new AppPushValidatorHandlerInterceptor());
////    }
////
////    public Message request(Message message) throws MsgException {
////        this.messagePreHandler.preHandle(message);
////        check(message);
////        this.messagePostHandler.postHandle(message);
////        if (this.dbLog || Objects.equals(message.getLogType(), LogType.DB.value())) {
////            Response<Long> resp = this.messageWriteService.createMessage(message);
////            if (!resp.isSuccess()) {
////                log.error("fail to create message by id={},cause:{}", message.getId(), resp.getError());
////                throw new JsonResponseException(resp.getError());
////            }
////
////            message.setId((Long)resp.getResult());
////        }
////
////        log.info("request send message={}", message);
////        return message;
////    }
////
////    public void check(Message message) {
////        this.validators.forEach(messageValidator -> {
////            messageValidator.check(message);
////        });
////    }
//}
