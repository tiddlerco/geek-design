package com.monday.desgin.edition2.storage;

import com.monday.desgin.edition2.req.RequestInfo;

import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements IMetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
    }

    @Override
    public List<RequestInfo> getRequestInfosByDuration(String apiName, long startTimestamp, long endTimestamp) {
        //...
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getAllRequestInfosByDuration(long startTimestamp, long endTimestamp) {
        //... TODO..
        return null;
    }
}