package com.locker.service;

import com.locker.bean.WeTokenBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Sejta on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void setTokenToRedisTemporaryHours() throws Exception {
        WeTokenBean weTokenBean=new WeTokenBean("yqlccc","tokentest",null,null,null);
        redisService.setTokenToRedisTemporaryHours(weTokenBean,(long)2);
    }

    @Test
    public void getOpenIdFromRedis() throws Exception {
        String red=redisService.getOpenIdFromRedis("tokentest");
        System.out.println(red);
    }

    @Test
    public void hasKey() throws Exception {

    }

}