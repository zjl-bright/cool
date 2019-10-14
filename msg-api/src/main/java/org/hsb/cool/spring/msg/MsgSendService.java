/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.hsb.cool.spring.msg;

import org.hsb.cool.spring.msg.enums.MsgChannel;
import org.hsb.cool.spring.msg.exception.MsgException;
import org.hsb.cool.spring.msg.model.Message;

public interface MsgSendService {

    MsgChannel getMsgChannel();

    void send(Message msg) throws MsgException;
}
