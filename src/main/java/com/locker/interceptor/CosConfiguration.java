package com.locker.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locker.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Sejta on 2018/5/28.
 */
@Configuration
public class CosConfiguration {

    @Value("${interceptor.token}")
    private boolean isTokenOn;

    private final RedisService redisService;

    @Autowired
    public CosConfiguration(RedisService redisService) {
        this.redisService = redisService;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(ObjectMapper mapper){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                InterceptorRegistration ir= registry.addInterceptor(new CosInterceptor(isTokenOn,mapper,redisService));
                ir.excludePathPatterns("/auth/**");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {

            }
        };
    }
}
