package com.darren1112.dwr.spi.qx.api;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-api参数dto
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
public class ApiParamDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求类型
     */
    private String type;

    /**
     * 请求参数
     */
    private T data;
}
