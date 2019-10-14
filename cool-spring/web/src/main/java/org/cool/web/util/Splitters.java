package org.cool.web.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/11/16
 * @Description:
 * @Version: 1.0
 */
public class Splitters {
    public static final Splitter DOT = Splitter.on(".").omitEmptyStrings().trimResults();
    public static final Splitter COMMA = Splitter.on(",").omitEmptyStrings().trimResults();
    public static final Splitter COLON = Splitter.on(":").omitEmptyStrings().trimResults();
    public static final Splitter AT = Splitter.on("@").omitEmptyStrings().trimResults();
    public static final Splitter SLASH = Splitter.on("/").omitEmptyStrings().trimResults();
    public static final Splitter SPACE = Splitter.on(" ").omitEmptyStrings().trimResults();
    public static final Splitter UNDERSCORE = Splitter.on("_").omitEmptyStrings().trimResults();

    public Splitters() {
    }

    public static List<Long> splitToLong(CharSequence sequence, Splitter splitter) {
        List<String> ss = splitter.splitToList(sequence);
        List<Long> res = Lists.newArrayListWithCapacity(ss.size());
        Iterator var4 = ss.iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            res.add(Long.parseLong(s));
        }

        return res;
    }

    public static List<Integer> splitToInteger(CharSequence sequence, Splitter splitter) {
        List<String> ss = splitter.splitToList(sequence);
        List<Integer> res = Lists.newArrayListWithCapacity(ss.size());
        Iterator var4 = ss.iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            res.add(Integer.parseInt(s));
        }

        return res;
    }
}
