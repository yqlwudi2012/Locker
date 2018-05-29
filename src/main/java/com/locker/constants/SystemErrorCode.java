package com.locker.constants;

/**
 * Created by Sejta on 2018/5/28.
 */

public class   SystemErrorCode {
    private SystemErrorCode(){
        throw new IllegalStateException(SystemErrorMsg.UTILITY_CLASS);
    }
    public static final String TOKEN_INVALID="10000";



}
