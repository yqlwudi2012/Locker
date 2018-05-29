package com.locker.constants;

/**
 * Created by Sejta on 2018/5/28.
 */

public class  SystemErrorMsg {
    private SystemErrorMsg(){
        throw new IllegalStateException(SystemErrorMsg.UTILITY_CLASS);
    }
    public static final String TOKEN_INVALID = "token_invalid";
    public static final String UTILITY_CLASS = "Utility Class";

}
