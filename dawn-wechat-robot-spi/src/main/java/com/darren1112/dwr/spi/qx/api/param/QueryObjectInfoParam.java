package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-查询对象信息param
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
public class QueryObjectInfoParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信id
     */
    private String wxid;
}
