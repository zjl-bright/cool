/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.cool.common.exception.ServiceException;
import org.cool.common.model.Response;

@Slf4j
public class RespHelper {

    public RespHelper() {}

    public static <T> T or(Response<T> resp, T failValue) {
        return resp.isSuccess() ? resp.getResult() : failValue;
    }

    public static <T> T or500(Response<T> resp) {
        if (resp.isSuccess()) {
            return resp.getResult();
        } else {
            throw new ServiceException(resp.getError());
        }
    }
}
