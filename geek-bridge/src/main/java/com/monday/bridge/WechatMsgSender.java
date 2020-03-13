package com.monday.bridge;

import java.util.List;

public class WechatMsgSender implements MsgSender{

    private List<String> wechates;

    public WechatMsgSender(List<String> wechates) {
        this.wechates = wechates;
    }

    @Override
    public void send(String msg) {
        // ...
    }
}
