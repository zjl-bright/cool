package org.cool.util;

import com.google.common.base.Joiner;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/11/16
 * @Description:
 * @Version: 1.0
 */
public class Joiners {
    public static final Joiner DOT = Joiner.on(".").skipNulls();
    public static final Joiner COMMA = Joiner.on(",").skipNulls();
    public static final Joiner COLON = Joiner.on(":").skipNulls();

    public Joiners() {
    }
}
