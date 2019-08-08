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

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }
}
