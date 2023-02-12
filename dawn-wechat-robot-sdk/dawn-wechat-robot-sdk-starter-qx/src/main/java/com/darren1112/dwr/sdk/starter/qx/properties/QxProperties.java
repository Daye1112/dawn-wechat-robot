package com.darren1112.dwr.sdk.starter.qx.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 千寻配置
 *
 * @author darren
 * @since 2023/02/11
 */
@Data
@ConfigurationProperties(prefix = "dawn.wechat.robot.qx")
public class QxProperties {

    /**
     * 客户端url
     */
    private String clientUrl = "http://127.0.0.1:7777/DaenWxHook/httpapi";

}
