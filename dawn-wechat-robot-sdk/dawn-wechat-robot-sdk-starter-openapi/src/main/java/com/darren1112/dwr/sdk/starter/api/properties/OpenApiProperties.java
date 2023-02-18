package com.darren1112.dwr.sdk.starter.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * openApi配置
 *
 * @author darren
 * @since 2023/02/18
 */
@Data
@ConfigurationProperties(prefix = "dwr.open-api")
public class OpenApiProperties {

    /**
     * 青云客openApi
     */
    private String QingYunKeOpenApi = "http://api.qingyunke.com/api.php";
}
