package com.darren1112.dwr.spi.qx.api.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-获取个人信息result
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
public class PersonalnfoResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信id
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
     * 设备
     */
    private String device;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 城市
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
     * 邮箱
     */
    private String email;

    /**
     * qq
     */
    private String qq;
}
