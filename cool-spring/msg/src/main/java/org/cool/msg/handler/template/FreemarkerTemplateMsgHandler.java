/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.handler.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.cool.common.utils.Throwables;
import org.cool.msg.exception.MsgException;
import org.cool.msg.interceptor.MsgTemplateHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.Serializable;
import java.util.Map;

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
    public String applyTemplate(String templateName, Map<String, Serializable> context){
        try{
            Template template = configuration.getTemplate(templateName);
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, context);
            return content;
        } catch (Exception e){
            log.error("FreeMarker template fail, template={}, cause={}", templateName, Throwables.getStackTraceAsString(e));
            throw new MsgException(e);
        }
    }
}
