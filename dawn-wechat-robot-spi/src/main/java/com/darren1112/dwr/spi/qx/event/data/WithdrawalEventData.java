package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 千寻-撤回事件Data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WithdrawalEventData extends BaseEventData {

    private static final long serialVersionUID = 1L;

    /**
     * 消息数据
     */
    private SubData data;

    /**
     * 子data
     *
     * @author darren
     * @since 2023/02/12
     */
    @Data
    public class SubData implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 来源类型：1|好友 2|群聊
         */
        private Integer fromType;

        /**
         * 消息来源：1|别人撤回 2|自己使用手机撤回 3|自己使用电脑撤回
         */
        private Integer msgSource;

        /**
         * fromType=1时为好友wxid，fromType=2时为群wxid
         */
        private String fromWxid;

        /**
         * 仅fromType=2时有效，为群内撤回消息人的wxid
         */
        private String finalFromWxid;

        /**
         * 撤回的消息内容
         */
        private String msg;
    }
}
