package com.locker.constants;

/**
 * Created by Sejta on 2018/5/28.
 */

public class SystemConstants {
    private SystemConstants(){
        throw new IllegalStateException(SystemErrorMsg.UTILITY_CLASS);
    }
    public static final String RESPONSE_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String OPEN_ID = "openid";
    public static final String BASE_CONTROLLER_PACKAGE = "com.locker.controller";
}
