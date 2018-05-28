package com.locker.service;

import com.locker.Entity.UserInfoDTO;
import com.locker.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sejta on 2018/5/28.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoDTO InsertUserInfo(UserInfoDTO user){
        return userInfoDao.save(user);
    }

    public UserInfoDTO findUserInfo(int id){

        return userInfoDao.getById(id);
    }

    public UserInfoDTO findUserInfo(String userName){

        return userInfoDao.findByUserName(userName);
    }

    public UserInfoDTO updateUserInfo(UserInfoDTO user){
        return userInfoDao.saveAndFlush(user);
    }

    public void deleteUserInfo(int id){
        userInfoDao.deleteById(id);
    }


}
