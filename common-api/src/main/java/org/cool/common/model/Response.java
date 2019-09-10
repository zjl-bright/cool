/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.common.model;

import com.google.common.base.MoreObjects;
import lombok.Data;
import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -750644833749014619L;

    //是否成功
    private boolean success;

    //返回结果集
    private T result;

    //错误提示
    private String error;

    public Response() {}

    public boolean isSuccess() {
        return this.success;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("success", this.success)
                .add("result", this.result).add("error", this.error).omitNullValues().toString();
    }

    public static <T> Response<T> ok(T data) {
        Response<T> resp = new Response<T>();
        resp.setSuccess(true);
        resp.setResult(data);
        return resp;
    }

    public static Response ok() {
        return ok(null);
    }

    public static Response fail(String error) {
        Response resp = new Response();
        resp.setSuccess(false);
        resp.setError(error);
        return resp;
    }
}
