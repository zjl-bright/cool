/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.advice;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.cool.common.exception.ServiceException;
import org.cool.common.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@ControllerAdvice
public class GlobalExceptionResolver {

    private final MessageSource messageSource;

    @Autowired
    public GlobalExceptionResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //拦截主动抛出的已知异常, 打印日志, 200返回, 发送response对象
    @ExceptionHandler(value = {ServiceException.class})
    @ResponseBody
    public Response serviceExceptionHandler(ServiceException e){
        if(Objects.nonNull(e.getParams())){
            log.error("ServiceException happened, params : {}, cause by : {}", String.join(",", e.getParams()), Throwables.getStackTraceAsString(e));
        }else{
            log.error("ServiceException happened, cause by : {}", Throwables.getStackTraceAsString(e));
        }
        Locale locale = new Locale("zh", "CN");
        String message = messageSource.getMessage(e.getMessage(), null, e.getMessage(), locale);
        return Response.fail(message);
    }

    //拦截未知的系统异常, 打印日志, 500返回不发送response对象
    @ExceptionHandler(value = {Exception.class})
    public void exceptionHandler(Exception e, HttpServletResponse response) throws IOException {
        log.error("Exception happened, cause by : {}", Throwables.getStackTraceAsString(e));
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
