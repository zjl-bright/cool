/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.common.exception;

public class ServiceException extends RuntimeException {

    private int status = 500;

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

    public ServiceException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public ServiceException(int status, String message, Throwable cause, String... params) {
        super(message, cause);
        this.status = status;
        this.params = params;
    }

    public String[] getParams(){
        return params;
    }
}
