package com.monday.design.alert.handler;

import com.monday.design.alert.AlertRule;
import com.monday.design.alert.ApiStatInfo;
import com.monday.design.alert.Notification;
import com.monday.design.alert.NotificationEmergencyLevel;

public class TimeoutAlertHandler extends AlertHandler{

    public TimeoutAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getTimeoutCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeout()) {
            notification.notify(NotificationEmergencyLevel.NORMAL, "...");
        }
    }
}
