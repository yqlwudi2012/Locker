package com.locker.service;


import com.locker.bean.WeTokenBean;
import com.locker.dao.UserInfoDao;
import com.locker.entity.UserInfoDTO;
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
        UserInfoDTO UserInfoDTO= MapperUtil.mapperToUserInfoDTO(weTokenBean);
        UserInfoDTO old=userInfoDao.getById(UserInfoDTO.getWeOpenId());
        if(ObjectUtils.isEmpty(old)){
                userInfoDao.save(UserInfoDTO);

        }else{
            old.setUserToken(UserInfoDTO.getUserToken());
            userInfoDao.save(old);
        }
    }

}
