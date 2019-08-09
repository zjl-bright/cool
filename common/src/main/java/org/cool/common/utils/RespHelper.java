package org.cool.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.cool.common.exception.ServiceException;
import org.cool.common.model.Response;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/11/28
 * @Description:
 * @Version: 1.0
 */
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

    public static void login(Long userId, HttpServletResponse resp) {
        resp.addHeader(HttpHeaders.AUTHORIZATION, userId.toString());
    }
}
