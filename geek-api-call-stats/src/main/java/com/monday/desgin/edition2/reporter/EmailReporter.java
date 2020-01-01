package com.monday.desgin.edition2.reporter;

import com.monday.desgin.edition2.storage.IMetricsStorage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** EmailReporter类的代码实现与Console类似，就没有给出了*/
public class EmailReporter {
    private IMetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public EmailReporter(IMetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startDailyReport() {
        executor.scheduleAtFixedRate(() -> {
            // TODO 集成邮件工具
        }, 0, 24, TimeUnit.HOURS);
    }
}