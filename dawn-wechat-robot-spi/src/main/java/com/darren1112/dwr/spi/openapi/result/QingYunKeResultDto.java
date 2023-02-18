package com.darren1112.dwr.spi.openapi.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 青云客openApi响应数据
 *
 * @author darren
 * @since 2023/02/18
 */
@Data
public class QingYunKeResultDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 0:正常
     */
    private Integer result;

    /**
     * 响应内容
     */
    private String content;
}
