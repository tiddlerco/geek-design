package com.monday.bridge.alert;

import java.util.HashMap;
import java.util.Map;

/**
 * AlertRule 存储告警规则.
 */
public class AlertRule {


    private static Map<String, RuleData> ruleDataMap = new HashMap<>();


    public RuleData getMatchedRule(String api) {
        return ruleDataMap.get(api);
    }

    public static class RuleData{
        
        private int maxTimeout;

        private int maxTps;

        private int maxErrorCount;

        public int getMaxTimeout() {
            return maxTimeout;
        }

        public void setMaxTimeout(int maxTimeout) {
            this.maxTimeout = maxTimeout;
        }

        public int getMaxTps() {
            return maxTps;
        }

        public void setMaxTps(int maxTps) {
            this.maxTps = maxTps;
        }

        public int getMaxErrorCount() {
            return maxErrorCount;
        }

        public void setMaxErrorCount(int maxErrorCount) {
            this.maxErrorCount = maxErrorCount;
        }
    }
}
