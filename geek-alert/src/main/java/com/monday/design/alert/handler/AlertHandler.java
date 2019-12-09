package com.monday.design.alert.handler;

import com.monday.design.alert.AlertRule;
import com.monday.design.alert.ApiStatInfo;
import com.monday.design.alert.Notification;

public abstract class AlertHandler {

    protected AlertRule rule;

    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
