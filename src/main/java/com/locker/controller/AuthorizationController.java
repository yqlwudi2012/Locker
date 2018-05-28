package com.locker.controller;

import com.locker.bean.TokenBean;
import com.locker.bean.WeTokenBean;
import com.locker.service.RedisService;
import com.locker.service.weChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/27.
 */
@RestController
@RequestMapping(value = "auth")
@Slf4j
public class AuthorizationController {

    @Autowired
    private weChatService weChatService;
    @Autowired
    private RedisService redisService;

    @PostMapping
    @RequestMapping(value = "/{code}")
    public TokenBean userAuthor(@PathVariable(value = "code",required = true) String code){
        System.out.println("new Connect come in..:"+code);
        WeTokenBean weTokenBean=weChatService.authUser(code);
        if(!StringUtils.isEmpty(weTokenBean.getSession_key()))
        redisService.setTokenToRedisTemporaryHours(weTokenBean,(long)2);

        TokenBean tokenBean=new TokenBean();
        tokenBean.setAccess_token(weTokenBean.getSession_key());
        return tokenBean;
    }

}
