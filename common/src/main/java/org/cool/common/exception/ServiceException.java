/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.exception;

/**
 * 业务异常
 *
 * @Auther: zjl
 * @Date: 2019-09-30
 * @Version: 1.0
 */
public class ServiceException extends RuntimeException {

    private Integer status = 406;

    private String[] params;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String... params) {
        super(message);
        this.params = params;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, String... params) {
        super(message, cause);
        this.params = params;
    }

    public ServiceException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public ServiceException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public ServiceException(Integer status, String message, Throwable cause, String... params) {
        super(message, cause);
        this.status = status;
        this.params = params;
    }

    public Integer getStatus(){
        return status;
    }

    public String[] getParams(){
        return params;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
