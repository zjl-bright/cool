/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.common.utils;

import org.cool.common.model.BaseUser;

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
