package com.monday.desgin.edition2.aggregator;


import com.monday.desgin.edition2.bo.RequestStat;
import com.monday.desgin.edition2.req.RequestInfo;

import java.util.Collections;
import java.util.List;

public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInSeconds) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long size = requestInfos.size();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            maxRespTime = Math.max(maxRespTime, respTime);
            minRespTime = Math.min(minRespTime, respTime);
            sumRespTime += respTime;
        }
        if (size > 0) {
            avgRespTime = sumRespTime / size;
        }
        long tps = (long) (size / durationInSeconds);
        Collections.sort(requestInfos, (o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            if (diff < 0.0) {
                return -1;
            }
            if (diff > 0.0) {
                return 1;
            }
            return 0;
        });

        if (size > 0) {
            int idx999 = (int)(size * 0.999);
            int idx99 = (int)(size * 0.99);
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(size);
        requestStat.setTps(tps);
        return requestStat;
    }
}
