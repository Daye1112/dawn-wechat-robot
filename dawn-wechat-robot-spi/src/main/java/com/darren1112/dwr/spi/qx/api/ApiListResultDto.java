package com.darren1112.dwr.spi.qx.api;

import com.darren1112.dwr.spi.qx.api.param.BaseApiResultParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 千寻-api响应dto
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ApiListResultDto<T> extends BaseApiResultParam {

    private static final long serialVersionUID = 1L;

    /**
     * 响应结果
     */
    private List<T> result;
}
