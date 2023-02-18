package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-账号变动事件Data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
public class AccountChangeEventData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型 1=上线，0=下线
     */
    private Integer type;

    /**
     * 微信id
     */
    private String wxid;

    /**
     * 端口号
     */
    private Integer port;
}
