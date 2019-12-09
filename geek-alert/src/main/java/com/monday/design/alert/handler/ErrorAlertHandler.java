package com.monday.design.alert.handler;

import com.monday.design.alert.AlertRule;
import com.monday.design.alert.ApiStatInfo;
import com.monday.design.alert.Notification;
import com.monday.design.alert.NotificationEmergencyLevel;

public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}