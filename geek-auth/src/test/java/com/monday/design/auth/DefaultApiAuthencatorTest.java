package com.monday.design.auth;

import org.junit.BeforeClass;
import org.junit.Test;

public class DefaultApiAuthencatorTest {

    private static ApiAuthencator authencator = new DefaultApiAuthencator();

    @BeforeClass
    public static void before() {
        authencator = new DefaultApiAuthencator();
    }

    @Test
    public void test_Success() {
        String baseUrl = "/auth/desgin/queryResources";
        String appId = "1004";
        long timestamp = System.currentTimeMillis();
        String password = "PASS-1004";
        String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
        ApiRequest req1 = new ApiRequest(baseUrl, appId, token, timestamp);
        authencator.auth(req1);
    }

    @Test
    public void testFail_passwordWrong() {
        String baseUrl = "/auth/desgin/queryResources";
        String appId = "1004";
        long timestamp = System.currentTimeMillis();
        String password = "222";
        String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
        ApiRequest req1 = new ApiRequest(baseUrl, appId, token, System.currentTimeMillis());
        authencator.auth(req1);
    }

    @Test
    public void testFail_tokenExpired() {
        String baseUrl = "/auth/desgin/queryResources";
        String appId = "1004";
        long timestamp = System.currentTimeMillis() + 1 * 60 * 1000;
        String password = "222";
        String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
        ApiRequest req1 = new ApiRequest(baseUrl, appId, token, System.currentTimeMillis());
        authencator.auth(req1);
    }
}
