package org.cool.common.exception;

import lombok.Data;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/11/27
 * @Description:
 * @Version: 1.0
 */
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
