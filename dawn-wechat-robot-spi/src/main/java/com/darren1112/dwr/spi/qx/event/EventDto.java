package com.darren1112.dwr.spi.qx.event;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-回调事件基础Dto
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
public class EventDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事件code
     */
    private Integer event;

    /**
     * 接收回调的微信id
     */
    private String wxid;

    /**
     * 数据
     */
    private T data;
}
