package com.locker.service;

import com.locker.Entity.UserInfoDTO;
import com.locker.bean.WeTokenBean;
import com.locker.dao.UserInfoDao;
import com.locker.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

/**
 * Created by Sejta on 2018/5/28.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional
    public void updateOrInsertUser(WeTokenBean weTokenBean){
        UserInfoDTO userInfoDTO= MapperUtil.mapperToUserInfoDTO(weTokenBean);
        UserInfoDTO old=userInfoDao.getById(userInfoDTO.getWeOpenId());
        if(ObjectUtils.isEmpty(old)){
                userInfoDao.save(userInfoDTO);

        }else{
            old.setUserToken(userInfoDTO.getUserToken());
            userInfoDao.save(old);
        }
    }

}
