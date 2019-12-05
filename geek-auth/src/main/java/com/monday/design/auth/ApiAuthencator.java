package com.monday.design.auth;

public interface ApiAuthencator {

    void auth(String baseUrl);

    void auth(ApiRequest apiRequest);

}
