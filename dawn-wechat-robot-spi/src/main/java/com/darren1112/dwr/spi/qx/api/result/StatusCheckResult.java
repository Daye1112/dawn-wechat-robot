package com.darren1112.dwr.spi.qx.api.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-微信状态检测result
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
public class StatusCheckResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开始运行时间戳
     */
    private String startTimeStamp;

    /**
     * 开始运行时间
     */
    private String startTime;

    /**
     * 已运行时间
     */
    private String runTime;

    /**
     * 接收消息数
     */
    private Integer recv;

    /**
     * 发送消息数
     */
    private Integer send;

    /**
     * 微信号
     */
    private String wxNum;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 微信id
     */
    private String wxid;

}