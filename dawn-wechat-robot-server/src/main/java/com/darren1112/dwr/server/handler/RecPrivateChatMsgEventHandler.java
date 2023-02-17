package com.darren1112.dwr.server.handler;

import com.darren1112.dwr.sdk.starter.qx.base.AbstractEventHandler;
import com.darren1112.dwr.sdk.starter.qx.enums.EventTypeEnum;
import com.darren1112.dwr.spi.qx.event.EventDto;
import com.darren1112.dwr.spi.qx.event.data.RecPrivateChatMsgEventData;
import org.springframework.stereotype.Component;

/**
 * 收到私聊消息（10009）
 *
 * @author darren
 * @since 2023/2/15
 */
@Component
public class RecPrivateChatMsgEventHandler extends AbstractEventHandler {

    /**
     * 处理方法
     *
     * @param eventDto 事件信息
     * @throws Exception 异常
     * @author darren
     * @since 2023/02/12
     */
    @Override
    @SuppressWarnings("unchecked")
    public void handler(EventDto eventDto) throws Exception {
        EventDto<RecPrivateChatMsgEventData> event = (EventDto<RecPrivateChatMsgEventData>) eventDto;
        RecPrivateChatMsgEventData.SubData data = event.getData().getData();
        String fromWxid = data.getFromWxid();
        String msg = data.getMsg();

    }

    /**
     * 获取事件类型
     *
     * @return {@link EventTypeEnum}
     * @author darren
     * @since 2023/02/12
     */
    @Override
    public EventTypeEnum eventType() {
        return EventTypeEnum.RecPrivateChatMsgEvent;
    }
}
