package org.cool.msg.handler.template;

import com.google.common.base.Throwables;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import org.cool.msg.interceptor.MsgTemplateHandlerInterceptor;
import org.cool.msg.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Slf4j
@Component
public class FreemarkerTemplateMsgHandler implements MsgTemplateHandlerInterceptor {

    @Autowired
    private Configuration configuration;

    @Override
    public String getSuffix(){
        return ".ftl";
    }

    @Override
    public Message applyTemplate(Message message){
        try{
            Template template = configuration.getTemplate(message.getTemplateName());
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, message.getContext());
            message.setContent(content);
            return message;
        } catch (Exception e){
            log.error("FreeMarker template fail, template={}, cause={}", message.getTemplateName(), Throwables.getStackTraceAsString(e));
            throw new MsgException(e);
        }
    }
}
