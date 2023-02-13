package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-发送文本消息param
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
public class SendMsgParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信id
     */
    private String wxid;

    /**
     * 文本内容
     */
    private String msg;
}
