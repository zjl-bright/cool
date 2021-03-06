/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.mongodb.util;

import org.cool.mongodb.BaseUser;

/**
 * 用户工具类
 *
 * @Auther: zjl
 * @Date: 2019-09-30
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
