/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg.util;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateUtil {

    private static final String REGEX = "\\{.*?}";

    /**
     * 将模版里的变量，根据传入的环境进行替换
     * @param template
     * @param context
     * @return
     */
    public static String render(String template, Map<String, Serializable> context) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String key = matcher.group();
            String value = context.get(trim(key)).toString();
            if (value != null) {
                template = template.replace(key, value);
            }
        }
        return template;
    }

    /**
     * 去除字符串的第一个和最后一个字符
     * @param str
     * @return
     */
    private static String trim(String str) {
        if (!Strings.isNullOrEmpty(str) && str.length() > 1) {
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }

}
