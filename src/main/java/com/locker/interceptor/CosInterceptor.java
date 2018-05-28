package com.locker.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locker.bean.ErrorBean;
import com.locker.constants.SystemConstants;
import com.locker.constants.SystemErrorCode;
import com.locker.constants.SystemErrorMsg;
import com.locker.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Sejta on 2018/5/28.
 */
//token 验证模式
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class CosInterceptor  implements HandlerInterceptor {

    private boolean authIsOn;
    private ObjectMapper mapper;
    private RedisService redisService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getQueryString());
        boolean authorization=true;
        if(authIsOn){//配置文件开启
            //redis 验证userToken
            Map param=request.getParameterMap();
            if(!ObjectUtils.isEmpty(param.get(SystemConstants.ACCESS_TOKEN))){
                String access_token=((String[])param.get(SystemConstants.ACCESS_TOKEN))[0];
                String openId=redisService.getOpenIdFromRedis(access_token);
                if(StringUtils.isEmpty(openId)){
                   authorization=false;
                }else{
                 request.setAttribute(SystemConstants.OPEN_ID,openId);
                }
            }else{
                authorization=false;
            }
        }
        if(!authorization){
            ErrorBean errorBean=new ErrorBean(SystemErrorCode.TOKEN_INVALID, SystemErrorMsg.TOKEN_INVALID);
            response.setContentType(SystemConstants.RESPONSE_CONTENT_TYPE);
            PrintWriter write = response.getWriter();
            write.write(mapper.writeValueAsString(errorBean));
            write.flush();
        }
        return authorization;
    }


}
