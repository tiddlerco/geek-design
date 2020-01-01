package com.monday.desgin.edition2.reporter;


import com.google.gson.Gson;
import com.monday.desgin.edition2.aggregator.Aggregator;
import com.monday.desgin.edition2.bo.RequestStat;
import com.monday.desgin.edition2.req.RequestInfo;
import com.monday.desgin.edition2.storage.IMetricsStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter {

    private IMetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(IMetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
            long endTimestamp = System.currentTimeMillis();
            long startTimestamp = endTimestamp - durationInSeconds * 1000;
            Map<String, List<RequestInfo>> allRequestInfos =
                    metricsStorage.getAllRequestInfosByDuration(startTimestamp, endTimestamp);

            System.out.println("Time Span: [" + startTimestamp + ", " + endTimestamp + "]");

            Map<String, RequestStat> requestStats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry : allRequestInfos.entrySet()) {
                String apiName = entry.getKey();
                List<RequestInfo> requestInfosPerApi = entry.getValue();
                // 第2个代码逻辑：根据原始数据，计算得到统计数据；
                RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInSeconds);
                requestStats.put(apiName, requestStat);
            }
            // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
            Gson gson = new Gson();
            System.out.println(gson.toJson(requestStats));

        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}

