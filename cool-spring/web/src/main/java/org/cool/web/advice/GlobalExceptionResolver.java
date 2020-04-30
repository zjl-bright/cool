/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.cool.common.enums.ResponseCode;
import org.cool.common.exception.ServiceException;
import org.cool.common.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Objects;

/**
 * 全局异常捕获
 *
 * @Auther: zjl
 * @Date: 2019-09-30
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionResolver {

    private final MessageSource messageSource;

    @Autowired
    public GlobalExceptionResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //拦截主动抛出的已知异常, 打印日志, 200返回, 发送response对象
    @ExceptionHandler(value = {ServiceException.class})
    public Response serviceExceptionHandler(ServiceException e){
        if(Objects.nonNull(e.getParams())){
            log.error("ServiceException happened, params : {}, cause by : {}", String.join(",", e.getParams()), Throwables.getStackTraceAsString(e));
        }else{
            log.error("ServiceException happened, cause by : {}", Throwables.getStackTraceAsString(e));
        }
        Locale locale = new Locale("zh", "CN");
        String message = messageSource.getMessage(e.getMessage(), null, e.getMessage(), locale);
        //除了401，其他被ServiceException捕捉到的异常都走406
        if(Objects.equals(ResponseCode.LOST.code(), e.getStatus())){
            return Response.fail401(message);
        }
        return Response.fail(message);
    }

    //拦截未知的系统异常, 打印日志, 500返回前端调用容错页面
    @ExceptionHandler(value = {Exception.class})
    public Response exceptionHandler(Exception e){
        log.error("Exception happened, cause by : {}", Throwables.getStackTraceAsString(e));
        return Response.fail500();
    }
}
