package com.darren1112.dwr.spi.qx.event.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 千寻-好友请求事件Data
 *
 * @author darren
 * @since 2023/02/12
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FriendRequestEventData extends BaseEventData {

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
         * 微信ID
         */
        private String wxid;

        /**
         * 微信号
         */
        private String wxNum;

        /**
         * 昵称
         */
        private String nick;

        /**
         * 昵称简拼
         */
        private String nickBrief;

        /**
         * 昵称全拼
         */
        private String nickWhole;

        /**
         * V3数据 同意好友验证时使用
         */
        private String v3;

        /**
         * V4数据 同意好友验证时使用
         */
        private String v4;

        /**
         * 签名
         */
        private String sign;

        /**
         * 国家
         */
        private String country;

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /**
         * 头像小图
         */
        private String avatarMinUrl;

        /**
         * 头像大图
         */
        private String avatarMaxUrl;

        /**
         * 性别，1=男
         */
        private String sex;

        /**
         * 附言
         */
        private String content;

        /**
         * 来源，1=qq 3=微信号 6=单向添加 10和13=通讯录 14=群聊 15=手机号 17=名片 30=扫一扫
         */
        private String scene;
    }
}
