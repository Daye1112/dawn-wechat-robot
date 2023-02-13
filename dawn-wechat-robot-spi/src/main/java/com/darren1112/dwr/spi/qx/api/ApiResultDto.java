package com.darren1112.dwr.spi.qx.api;

import com.darren1112.dwr.spi.qx.api.param.BaseApiResultParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 千寻-api响应dto
 *
 * @author darren
 * @since 2023/2/13
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ApiResultDto<T> extends BaseApiResultParam {

    private static final long serialVersionUID = 1L;

    /**
     * 响应结果
     */
    private T result;

}
