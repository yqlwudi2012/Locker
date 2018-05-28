package com.locker.service;

import com.locker.bean.WeTokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sejta on 2018/5/28.
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setTokenToRedisPermanent(WeTokenBean weTokenBean){
        this.redisTemplate.opsForValue().set(weTokenBean.getSession_key(),weTokenBean.getOpenid());
    }

    public void setTokenToRedisTemporaryHours(WeTokenBean weTokenBean,Long timeOut){
        this.redisTemplate.opsForValue().set(weTokenBean.getSession_key(),weTokenBean.getOpenid(),timeOut, TimeUnit.HOURS);
    }
    public void setTokenToRedisTemporaryMinutes(WeTokenBean weTokenBean,Long timeOut){
        this.redisTemplate.opsForValue().set(weTokenBean.getSession_key(),weTokenBean.getOpenid(),timeOut, TimeUnit.MINUTES);
    }
    public void setTokenToRedisTemporarySeconds(WeTokenBean weTokenBean,Long timeOut){
        this.redisTemplate.opsForValue().set(weTokenBean.getSession_key(),weTokenBean.getOpenid(),timeOut, TimeUnit.SECONDS);
    }
    public String getOpenIdFromRedis(String access_token){
        if(redisTemplate.hasKey(access_token)) {
            return redisTemplate.opsForValue().get(access_token).toString();
        }else{
            return null;
        }
    }
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
