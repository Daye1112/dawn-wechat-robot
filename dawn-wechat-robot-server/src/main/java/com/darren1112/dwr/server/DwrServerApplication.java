package com.darren1112.dwr.server;

import com.darren1112.dwr.common.util.EnvironmentAwareUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 微信机器人server启动类
 *
 * @author darren
 * @since 2023/2/15
 */
@EnableConfigurationProperties
@SpringBootApplication
public class DwrServerApplication {

    public static void main(String[] args) {
        EnvironmentAwareUtil.adjust();
        SpringApplication.run(DwrServerApplication.class, args);
    }
}
