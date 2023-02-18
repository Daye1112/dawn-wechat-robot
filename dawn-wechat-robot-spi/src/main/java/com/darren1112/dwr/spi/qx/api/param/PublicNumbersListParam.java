package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-获取公众号列表param
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
public class PublicNumbersListParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 1=从缓存中获取，2=重新遍历二叉树并刷新缓存
     */
    private String type;
}
