package com.locker.bean;

import lombok.*;

/**
 * Created by Administrator on 2018/5/27.
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WeTokenBean {
    private String openid;
    private String session_key;
    private String unionid;
    private String errcode;
    private String errmsg;
}
