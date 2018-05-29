package com.locker.util;

import com.locker.Entity.UserInfoDTO;
import com.locker.bean.WeTokenBean;

/**
 * Created by Sejta on 2018/5/29.
 */
public class MapperUtil {
    public static UserInfoDTO mapperToUserInfoDTO(WeTokenBean weTokenBean){
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setWeOpenId(weTokenBean.getOpenid());
        userInfoDTO.setUserToken(weTokenBean.getSession_key());
        return userInfoDTO;
    }
}
