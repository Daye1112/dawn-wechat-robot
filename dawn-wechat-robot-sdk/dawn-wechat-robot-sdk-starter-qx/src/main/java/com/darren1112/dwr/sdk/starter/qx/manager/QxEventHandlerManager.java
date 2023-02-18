package com.darren1112.dwr.sdk.starter.qx.manager;

import com.darren1112.dwr.common.exception.BadRequestException;
import com.darren1112.dwr.common.util.MapUtil;
import com.darren1112.dwr.sdk.starter.qx.base.AbstractEventHandler;
import com.darren1112.dwr.sdk.starter.qx.enums.QxErrorEnum;
import com.darren1112.dwr.sdk.starter.qx.manager.base.AbstractManager;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 千寻-事件处理器管理者
 *
 * @author darren
 * @since 2023/02/12
 */
@Slf4j
public class QxEventHandlerManager extends AbstractManager {

    private Map<Integer, AbstractEventHandler> eventHandlerMap = new HashMap<>();

    /**
     * 根据事件类型获取事件处理器
     *
     * @param event 事件类型
     * @return {@link AbstractEventHandler}
     * @author darren
     * @since 2023/02/12
     */
    public AbstractEventHandler getEventHandler(Integer event) {
        AbstractEventHandler eventHandler = this.eventHandlerMap.get(event);
        if (eventHandler == null) {
            throw new BadRequestException(QxErrorEnum.EVENT_HANDLER_NOT_EXIST);
        }
        return eventHandler;
    }

    /**
     * 初始方法
     *
     * @throws Exception 异常
     * @author darren
     * @since 2022/01/15
     */
    @Override
    public void init() throws Exception {
        // 查询所有实现该类的实例
        Map<String, AbstractEventHandler> eventHandlerBeanMap = this.applicationContext.getBeansOfType(AbstractEventHandler.class);
        if (MapUtil.isEmpty(eventHandlerBeanMap)) {
            log.warn("千寻-事件处理器总数: 0");
        }
        // 遍历装配
        for (Map.Entry<String, AbstractEventHandler> eventHandlerEntry : eventHandlerBeanMap.entrySet()) {
            AbstractEventHandler eventHandler = eventHandlerEntry.getValue();
            this.eventHandlerMap.put(eventHandler.eventType().getEvent(), eventHandler);
            log.info("千寻-事件处理器: {} 装配成功", eventHandlerEntry.getKey());
        }
        log.info("寻-事件处理器总数: {}", eventHandlerBeanMap.size());
    }

    /**
     * 销毁方法
     *
     * @author darren
     * @since 2022/01/15
     */
    @Override
    public void destroy() {

    }
}
