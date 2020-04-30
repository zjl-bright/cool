package org.cool.web.advice;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * TODO
 *
 * @Auther: zjl
 * @Date: 2020/4/30
 * @Version: 1.0
 */
public class Throwables {
    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
