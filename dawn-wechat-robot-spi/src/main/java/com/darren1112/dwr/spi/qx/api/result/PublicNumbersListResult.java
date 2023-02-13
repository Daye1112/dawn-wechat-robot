package com.darren1112.dwr.spi.qx.api.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-获取公众号列表result
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
public class PublicNumbersListResult implements Serializable {

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
     * 备注
     */
    private String remark;

    /**
     * 昵称简拼
     */
    private String nickBrief;

    /**
     * 昵称全拼
     */
    private String nickWhole;

    /**
     * 备注简拼
     */
    private String remarkBrief;

    /**
     * 备注全拼
     */
    private String remarkWhole;

    /**
     * 英文简称
     */
    private String enBrief;

    /**
     * 英文全称
     */
    private String enWhole;

    /**
     * V3数据
     */
    private String v3;

    /**
     * V4数据
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
     * 朋友圈背景图
     */
    private String momentsBackgroudImgUrl;

    /**
     * 头像小图
     */
    private String avatarMinUrl;

    /**
     * 头像小图
     */
    private String avatarMaxUrl;

    /**
     * 性别 1=男，2=女
     */
    private String sex;

    /**
     * 群成员数量 仅当对象是群聊时有效
     */
    private Integer memberNum;
}
