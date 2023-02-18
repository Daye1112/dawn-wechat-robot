package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-api响应基础dto
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
public class BaseApiResultParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应code 200:成功
     */
    private Integer code;

    /**
     * 响应结果
     */
    private String msg;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 微信id
     */
    private String wxid;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 进程号
     */
    private Integer pid;

    /**
     * 标记
     */
    private String flag;
}
