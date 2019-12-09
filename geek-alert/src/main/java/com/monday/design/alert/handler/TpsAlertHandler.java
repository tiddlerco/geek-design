package com.monday.design.alert.handler;

import com.monday.design.alert.AlertRule;
import com.monday.design.alert.ApiStatInfo;
import com.monday.design.alert.Notification;
import com.monday.design.alert.NotificationEmergencyLevel;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }

}