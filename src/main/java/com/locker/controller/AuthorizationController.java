package com.locker.controller;

import com.locker.bean.TokenBean;
import com.locker.bean.WeTokenBean;
import com.locker.service.RedisService;
import com.locker.service.UserInfoService;
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
    private WeChatService weChatService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    @RequestMapping(value = "/{code}")
    public TokenBean userAuthor(@PathVariable(value = "code",required = true) String code){
        WeTokenBean weTokenBean=weChatService.authUser(code);
        TokenBean tokenBean=new TokenBean();
        if(!StringUtils.isEmpty(weTokenBean.getSession_key())) {
            redisService.setTokenToRedisTemporaryHours(weTokenBean, (long) 2);
            userInfoService.updateOrInsertUser(weTokenBean);
            tokenBean.setAccess_token(weTokenBean.getSession_key());
        }else{
            tokenBean.setError_code(weTokenBean.getErrcode());
            tokenBean.setError_msg(weTokenBean.getErrmsg());
        }
        return tokenBean;
    }

}
