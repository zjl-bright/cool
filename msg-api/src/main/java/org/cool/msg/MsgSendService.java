/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
package org.cool.msg;

import org.cool.msg.enums.MsgChannel;
import org.cool.msg.exception.MsgException;
import org.cool.msg.model.Message;

public interface MsgSendService {

    MsgChannel getMsgChannel();

    void send(Message msg) throws MsgException;
}
