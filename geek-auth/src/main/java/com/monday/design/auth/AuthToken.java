package com.monday.design.auth;

import com.monday.design.auth.util.MD5Utils;

import java.util.Map;

public class AuthToken {


    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private static final String SEPARATE = "@";

    private String token;

    private long createTime;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;


    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this(token, createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }


    public static AuthToken create(String baseUrl, long createTime, Map<String, Object> param) {
        // TODO... 创建AutoToken
        return null;
    }

    public static AuthToken generate(String originalUrl, String appId, long timestamp, String password) {
        String token = generateTokenString(originalUrl, appId, timestamp, password);
        AuthToken authToken = new AuthToken(token, timestamp);
        return authToken;
    }



    public static String generateTokenString(String originalUrl, String appId, long timestamp, String password) {
        StringBuffer sb = new StringBuffer(originalUrl);
        sb.append(SEPARATE).append(appId);
        sb.append(SEPARATE).append(timestamp);
        sb.append(SEPARATE).append(password);
        return MD5Utils.md5(sb.toString());
    }


    public String getToken() {
        return this.token;
    }

    public boolean isExpired() {
        return createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }

}
