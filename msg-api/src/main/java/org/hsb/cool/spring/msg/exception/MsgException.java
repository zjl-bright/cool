/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg.exception;

public class MsgException extends RuntimeException{

    public MsgException() {
    }

    public MsgException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgException(String message) {
        super(message);
    }

    public MsgException(Throwable cause) {
        super(cause);
    }

}
