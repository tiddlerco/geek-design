package com.monday.desgin.edition2;


import com.monday.desgin.edition2.req.RequestInfo;
import com.monday.desgin.edition2.storage.IMetricsStorage;
import com.monday.desgin.util.StringUtils;

public class MetricsCollector {
    /**基于接口而非实现编程*/
    private IMetricsStorage metricsStorage;

    /**依赖注入*/
    public MetricsCollector(IMetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    /**用一个函数代替了最小原型中的两个函数*/
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}

