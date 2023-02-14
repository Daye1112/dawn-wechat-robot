package com.darren1112.dwr.sdk.starter.qx.config;

import com.darren1112.dwr.common.util.HttpClientUtil;
import com.darren1112.dwr.sdk.starter.qx.manager.QxEventHandlerManager;
import com.darren1112.dwr.sdk.starter.qx.properties.QxProperties;
import com.darren1112.dwr.sdk.starter.qx.remoting.QxRemoting;
import com.darren1112.dwr.sdk.starter.qx.remoting.impl.QxRemotingImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 千寻自动装配类
 *
 * @author darren
 * @since 2023/02/11
 */
@EnableConfigurationProperties(QxProperties.class)
public class QxAutoConfig {

    /**
     * 千寻-事件处理器管理者
     *
     * @return {@link QxEventHandlerManager}
     * @author darren
     * @since 2023/02/12
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public QxEventHandlerManager qxEventHandlerManager() {
        return new QxEventHandlerManager();
    }

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
     * 千寻-客户端remoting
     *
     * @param qxProperties   千寻配置
     * @param httpClientUtil httpClient工具类
     * @return {@link QxRemoting}
     * @author darren
     * @since 2023/2/14
     */
    @Bean
    public QxRemoting qxRemoting(QxProperties qxProperties, HttpClientUtil httpClientUtil) {
        return new QxRemotingImpl(qxProperties, httpClientUtil);
    }
}
