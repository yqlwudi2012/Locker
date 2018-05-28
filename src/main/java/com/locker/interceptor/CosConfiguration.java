package com.locker.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locker.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Sejta on 2018/5/28.
 */
@Configuration
public class CosConfiguration extends WebMvcConfigurationSupport {

    @Value("${interceptor.token}")
    private boolean isTokenOn;

    @Value("${interceptor.origins}")
    private String[] origins;

    @Autowired
    private ObjectMapper mapper;

    private final RedisService redisService;

    @Autowired
    public CosConfiguration(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CosInterceptor(isTokenOn, mapper, redisService))
                .addPathPatterns("/**").excludePathPatterns("/", "/auth/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
