package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 千寻-收到群聊消息事件Data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RecGroupChatMsgEventData extends BaseEventData {

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
         * 收到这条消息的13位现行时间戳
         */
        private String timeStamp;

        /**
         * 来源类型：1|私聊 2|群聊 3|公众号
         */
        private Integer fromType;

        /**
         * 消息类型：1|文本 3|图片 34|语音 42|名片 43|视频 47|动态表情 48|地理位置 49|分享链接或附件 2001|红包 2002|小程序 2003|群邀请 10000|系统消息
         */
        private Integer msgType;

        /**
         * 消息来源：0|别人发送 1|自己手机发送
         */
        private Integer msgSource;

        /**
         * fromType=1时为好友wxid，fromType=2时为群wxid，fromType=3时公众号wxid
         */
        private String fromWxid;

        /**
         * 仅fromType=2时有效，为群内发言人wxid
         */
        private String finalFromWxid;

        /**
         * 仅fromType=2，且msgSource=0时有效，为消息中艾特人wxid列表
         */
        private List<String> atWxidList;

        /**
         * 仅fromType=2时有效，0
         */
        private Integer silence;

        /**
         * 仅fromType=2时有效，群成员数量
         */
        private Integer membercount;

        /**
         * 消息签名
         */
        private String signature;

        /**
         * 消息内容
         */
        private String msg;

        /**
         * 消息内容的Base64
         */
        private String msgBase64;
    }
}
