package com.locker.util;


import com.locker.bean.WeTokenBean;
import com.locker.constants.SystemErrorMsg;
import com.locker.entity.UserInfoDTO;

/**
 * Created by Sejta on 2018/5/29.
 */
public class MapperUtil {
    private MapperUtil(){
        throw new IllegalStateException(SystemErrorMsg.UTILITY_CLASS);
    }
    public static UserInfoDTO mapperToUserInfoDTO(WeTokenBean weTokenBean){
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setWeOpenId(weTokenBean.getOpenid());
        userInfoDTO.setUserToken(weTokenBean.getSession_key());
        return userInfoDTO;
    }
}
