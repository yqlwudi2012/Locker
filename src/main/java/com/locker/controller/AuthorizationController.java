package com.locker.controller;

import com.locker.bean.TokenBean;
import com.locker.bean.WeTokenBean;
import com.locker.service.weChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/27.
 */
@RestController
@RequestMapping(value = "auth")
public class AuthorizationController {

    @Autowired
    private weChatService weChatService;

    @PostMapping
    @RequestMapping(value = "/{code}")
    public TokenBean userAuthor(@PathVariable(value = "code",required = true) String code){
        System.out.println("new Connect come in..:"+code);
        WeTokenBean weTokenBean=weChatService.authUser(code);
        System.out.println(weTokenBean.toString());
        TokenBean tokenBean=new TokenBean();
        tokenBean.setAccess_token(weTokenBean.getSession_key());
        return tokenBean;
    }

}
