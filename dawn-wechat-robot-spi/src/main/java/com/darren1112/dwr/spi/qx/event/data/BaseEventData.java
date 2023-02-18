package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-基础时间data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
public class BaseEventData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 描述
     */
    private String des;

    /**
     * 收到这条消息的13位现行时间戳
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
