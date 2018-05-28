package com.locker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sejta on 2018/5/28.
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "")
    public String getUserOrders(@RequestAttribute(value = "openid",required = false)String openid){
        log.info("Interceptor Test:"+openid);
        return openid;
    }
}
