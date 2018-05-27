package com.locker.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2018/5/27.
 */
@Setter
@Getter
@ToString
public class WeTokenBean {
    private String openid;
    private String session_key;
    private String unionid;
}
