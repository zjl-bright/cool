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

    private String param;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String param, String message) {
        super(message);
        this.param = param;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String param, String message, Throwable cause) {
        super(message, cause);
        this.param = param;
    }

    public ServiceException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public ServiceException(String param, int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.param = param;
    }

    public String getParam(){
        return param;
    }
}
