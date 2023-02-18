package com.darren1112.dwr.spi.openapi.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 青云客openApi请求参数
 *
 * @author darren
 * @since 2023/02/18
 */
@Data
@Accessors(chain = true)
public class QingYunKeParamDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 必需，固定值
     */
    private String key = "free";

    /**
     * 可选，0表示智能识别
     */
    private Integer appid = 0;

    /**
     * 必需，关键词，提交前请先经过 urlencode 处理
     */
    private String msg;
}
