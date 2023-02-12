package com.darren1112.dwr.sdk.starter.qx.config;

import com.darren1112.dwr.sdk.starter.qx.manager.QxEventHandlerManager;
import com.darren1112.dwr.sdk.starter.qx.properties.QxProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private QxProperties qxProperties;

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
}
