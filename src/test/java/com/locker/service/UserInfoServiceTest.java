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
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void updateOrInsertUser() throws Exception {
        WeTokenBean weTokenBean=new WeTokenBean();
        weTokenBean.setOpenid("xxx");
        weTokenBean.setSession_key("xxx");
        userInfoService.updateOrInsertUser(weTokenBean);
    }



}