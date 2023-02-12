package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 千寻-转账事件Data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TransferEventData extends BaseEventData {

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
    public static class SubData implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 对方wxid
         */
        private String fromWxid;

        /**
         * 1|收到转账 2|对方接收转账 3|发出转账 4|自己接收转账 5|对方退还 6|自己退还
         */
        private int msgSource;

        /**
         * 1|即时到账 2|延时到账
         */
        private int transType;

        /**
         * 金额，单位元
         */
        private String money;

        /**
         * 转账备注
         */
        private String memo;

        /**
         * 转账ID
         */
        private String transferid;

        /**
         * 10位时间戳
         */
        private String invalidtime;
    }
}
