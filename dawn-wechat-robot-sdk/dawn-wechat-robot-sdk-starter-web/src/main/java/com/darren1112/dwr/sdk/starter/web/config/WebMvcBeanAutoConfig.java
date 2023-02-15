package com.darren1112.dwr.sdk.starter.web.config;

import com.darren1112.dwr.sdk.starter.web.exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;

/**
 * mvc的bean管理配置类
 *
 * @author darren
 * @since 2020/1/6 18:41
 */
public class WebMvcBeanAutoConfig {

    @Bean
    public DefaultWebMvcAutoConfig defaultWebMvcAutoConfig() {
        return new DefaultWebMvcAutoConfig();
    }

    @Bean
    public GlobalExceptionHandler defaultGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
