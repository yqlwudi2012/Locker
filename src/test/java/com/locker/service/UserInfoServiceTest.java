package com.locker.service;

import com.locker.Entity.UserInfoDTO;
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
    public void insertUserInfo() throws Exception {
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setUserName("clark");
        userInfoService.InsertUserInfo(userInfoDTO);
    }

    @Test
    public void findUserInfo() throws Exception {
        UserInfoDTO user=userInfoService.findUserInfo(1);
        System.out.println(user.getUserName());

        UserInfoDTO user1=userInfoService.findUserInfo("gouzi");
        System.out.println(user.getUserName());
    }

    @Test
    public void updateUserInfo() throws Exception {
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setUserName("gouzi");
        userInfoDTO.setUserId(1);
        userInfoService.updateUserInfo(userInfoDTO);
    }

    @Test
    public void deleteUserInfo() throws Exception {
        userInfoService.deleteUserInfo(2);
    }

}