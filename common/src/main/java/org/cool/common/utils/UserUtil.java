package org.cool.common.utils;

import org.cool.common.model.BaseUser;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/12/8
 * @Description:
 * @Version: 1.0
 */
public final class UserUtil {

    private static ThreadLocal<BaseUser> user = new ThreadLocal();

    public static <T extends BaseUser> void putCurrentUser(T baseUser) {
        user.set(baseUser);
    }

    public static <T extends BaseUser> T getCurrentUser() {
        return (T)user.get();
    }

    public static void clearCurrentUser() {
        user.remove();
    }

    public static String getUserId() {
        BaseUser baseUser = user.get();
        return null != baseUser ? baseUser.getId() : null;
    }
}
