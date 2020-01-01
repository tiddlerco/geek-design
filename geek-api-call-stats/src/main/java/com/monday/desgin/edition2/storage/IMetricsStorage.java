package com.monday.desgin.edition2.storage;

import com.monday.desgin.edition2.req.RequestInfo;

import java.util.List;
import java.util.Map;


public interface IMetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfosByDuration(String apiName, long startTimestamp, long endTimestamp);

    Map<String, List<RequestInfo>> getAllRequestInfosByDuration(long startTimestamp, long endTimestamp);

}

