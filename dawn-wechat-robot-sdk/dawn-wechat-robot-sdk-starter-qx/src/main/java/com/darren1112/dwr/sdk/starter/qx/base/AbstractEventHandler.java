package com.darren1112.dwr.sdk.starter.qx.base;

import com.darren1112.dwr.sdk.starter.qx.enums.EventTypeEnum;
import com.darren1112.dwr.spi.qx.event.EventDto;

/**
 * 事件处理器基础类
 *
 * @author darren
 * @since 2023/02/12
 */
public abstract class AbstractEventHandler {


    /**
     * 处理方法
     *
     * @param eventDto 事件信息
     * @throws Exception 异常
     * @author darren
     * @since 2023/02/12
     */
    public abstract void handler(EventDto eventDto) throws Exception;

    /**
     * 获取事件类型
     *
     * @return {@link EventTypeEnum}
     * @author darren
     * @since 2023/02/12
     */
    public abstract EventTypeEnum eventType();
}
