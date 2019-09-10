/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.util;

import com.google.common.base.Joiner;

public class Joiners {
    public static final Joiner DOT = Joiner.on(".").skipNulls();
    public static final Joiner COMMA = Joiner.on(",").skipNulls();
    public static final Joiner COLON = Joiner.on(":").skipNulls();

    public Joiners() {
    }
}
