package org.cool.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * TODO
 *
 * @Auther: zjl
 * @Date: 2019-10-14
 * @Version: 1.0
 */
public class Throwables {

    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
