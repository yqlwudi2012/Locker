package com.locker.service;


import com.locker.bean.WeTokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/5/27.
 */
@Service
public class WeChatService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${weChat.appID}")
    private String appId;
    @Value("${weChat.appSecret}")
    private String secret;
    @Value("${weChat.auth_url}")
    private String authUrl;

    public WeTokenBean authUser(String code){

        return restTemplate.getForObject(authUrl,WeTokenBean.class,appId,secret,code);

    }
}
