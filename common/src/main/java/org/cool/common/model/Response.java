/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cool.common.enums.ResponseCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * resp结果包装类
 *
 * @Auther: zjl
 * @Date: 2019-09-30
 * @Version: 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -750644833749014619L;

    //状态码
    private Integer code;

    //消息
    private String message;

    //返回结果集
    private T result;

    //是否成功
    private boolean success;

    public Response() {}

    private Response(ResponseCode responseCode) {
        this.code = responseCode.code();
        this.message = responseCode.message();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public static Response ok() {
        return new Response(ResponseCode.SUCCESS).setSuccess(true);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>(ResponseCode.SUCCESS).setResult(data).setSuccess(true);
    }

    public static Response fail401(String message) {
        return code(ResponseCode.LOST, message);
    }

    public static Response fail(String message) {
        return code(ResponseCode.TIP_ERROR, message);
    }

    public static Response fail500() {
        return code(ResponseCode.UNKNOWN_ERROR, null);
    }

    public static Response fail500(String message) {
        return code(ResponseCode.UNKNOWN_ERROR, message);
    }

    private static Response code(ResponseCode responseCode, String message){
        Response resp = new Response(responseCode).setSuccess(false);
        if(Objects.isNull(message) || message.isBlank()){
            return resp;
        }else{
            return resp.setMessage(message);
        }
    }
}
