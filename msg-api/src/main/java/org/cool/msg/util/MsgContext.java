package org.cool.msg.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MsgContext extends HashMap<String, Serializable> implements Serializable {

    public MsgContext() {}

    public static MsgContext of(String key, Serializable value) {
        MsgContext context = new MsgContext();
        context.put(key, value);
        return context;
    }

    public static MsgContext of(String k1, Serializable v1, String k2, Serializable v2) {
        MsgContext context = new MsgContext();
        context.put(k1, v1);
        context.put(k2, v2);
        return context;
    }

    public static MsgContext of(String k1, Serializable v1, String k2, Serializable v2, String k3, Serializable v3) {
        MsgContext context = new MsgContext();
        context.put(k1, v1);
        context.put(k2, v2);
        context.put(k3, v3);
        return context;
    }

    public static MsgContext of(String k1, Serializable v1, String k2, Serializable v2, String k3, Serializable v3, String k4, Serializable v4) {
        MsgContext context = new MsgContext();
        context.put(k1, v1);
        context.put(k2, v2);
        context.put(k3, v3);
        context.put(k4, v4);
        return context;
    }

    public static MsgContext of(String k1, Serializable v1, String k2, Serializable v2, String k3, Serializable v3, String k4, Serializable v4, String k5, Serializable v5) {
        MsgContext context = new MsgContext();
        context.put(k1, v1);
        context.put(k2, v2);
        context.put(k3, v3);
        context.put(k4, v4);
        context.put(k5, v5);
        return context;
    }

    public static MsgContext of(Map<String, ? extends Serializable> map) {
        MsgContext context = new MsgContext();
        context.putAll(map);
        return context;
    }
}
