package com.locker.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/5/27.
 */
@Setter
@Getter
public class TokenBean {
    private String access_token;
    private String error_code;
    private String expri_in;
    private String error_msg;
}
