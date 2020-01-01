package com.monday.desgin.edition2.demo;


import com.monday.desgin.edition2.MetricsCollector;
import com.monday.desgin.edition2.reporter.ConsoleReporter;
import com.monday.desgin.edition2.reporter.EmailReporter;
import com.monday.desgin.edition2.req.RequestInfo;
import com.monday.desgin.edition2.storage.IMetricsStorage;
import com.monday.desgin.edition2.storage.RedisMetricsStorage;

import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        IMetricsStorage storage = new RedisMetricsStorage();
        MetricsCollector collector = new MetricsCollector(storage);
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(5, 5);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.startDailyReport();

        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        TimeUnit.SECONDS.sleep(1);
    }
}