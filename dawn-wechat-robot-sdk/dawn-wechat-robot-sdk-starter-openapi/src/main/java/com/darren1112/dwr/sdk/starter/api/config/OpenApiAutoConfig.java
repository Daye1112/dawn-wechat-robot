package com.darren1112.dwr.sdk.starter.api.config;

import com.darren1112.dwr.common.util.HttpClientUtil;
import com.darren1112.dwr.sdk.starter.api.properties.OpenApiProperties;
import com.darren1112.dwr.sdk.starter.api.remoting.OpenApiRemoting;
import com.darren1112.dwr.sdk.starter.api.remoting.impl.OpenApiRemotingImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * api自动装配类
 *
 * @author darren
 * @since 2023/02/18
 */
@EnableConfigurationProperties(OpenApiProperties.class)
public class OpenApiAutoConfig {

    /**
     * httpClient工具类
     *
     * @author darren
     * @since 2023/2/14
     */
    @Bean
    @ConditionalOnMissingBean
    public HttpClientUtil httpClientUtil() {
        return new HttpClientUtil();
    }

    /**
     * api远程调用类
     *
     * @param httpClientUtil    httpClient工具
     * @param openApiProperties openApi配置
     * @return {@link OpenApiRemoting}
     * @author darren
     * @since 2023/02/18
     */
    @Bean
    public OpenApiRemoting openApiRemoting(HttpClientUtil httpClientUtil,
                                           OpenApiProperties openApiProperties) {
        return new OpenApiRemotingImpl(httpClientUtil, openApiProperties);
    }
}
