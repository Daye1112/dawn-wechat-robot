package com.darren1112.dwr.sdk.starter.qx.enums;

import com.darren1112.dwr.spi.qx.event.data.*;

/**
 * 事件类型枚举
 *
 * @author darren
 * @since 2023/02/12
 */
public enum EventTypeEnum {

    /**
     * 事件
     */
    AccountChangeEvent(10014, AccountChangeEventData.class),
    FriendRequestEvent(10011, FriendRequestEventData.class),
    PaymentEvent(10007, PaymentEventData.class),
    RecGroupChatMsgEvent(10008, RecGroupChatMsgEventData.class),
    RecPrivateChatMsgEvent(10009, RecPrivateChatMsgEventData.class),
    SendMsgEvent(10010, SendMsgEventData.class),
    TransferEvent(10006, TransferEventData.class),
    WithdrawalEvent(10013, WithdrawalEventData.class);

    /**
     * 事件类型
     */
    private Integer event;

    /**
     * 事件对象类型
     */
    private Class clazz;

    EventTypeEnum(Integer event, Class clazz) {
        this.event = event;
        this.clazz = clazz;
    }

    public Integer getEvent() {
        return event;
    }

    public Class getClazz() {
        return clazz;
    }
}
