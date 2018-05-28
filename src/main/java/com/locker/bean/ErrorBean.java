package com.locker.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Sejta on 2018/5/28.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBean {
    private String error_code;
    private String msg;
}
