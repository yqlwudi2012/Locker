package com.locker.service;


import com.locker.bean.WeTokenBean;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/27.
 */
@Service
public class weChatService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${weChat.appID}")
    private String AppId;
    @Value("${weChat.appSecret}")
    private String secret;
    @Value("${weChat.auth_url}")
    private String auth_url;

    private String grant_type="authorization_code";
    public WeTokenBean authUser(String code){

        return restTemplate.getForObject(auth_url,WeTokenBean.class,AppId,secret,code);

    }
}