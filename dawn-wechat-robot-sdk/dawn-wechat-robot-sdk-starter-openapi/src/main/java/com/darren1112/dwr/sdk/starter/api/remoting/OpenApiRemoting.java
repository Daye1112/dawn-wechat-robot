package com.darren1112.dwr.sdk.starter.api.remoting;

import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.spi.openapi.param.QingYunKeParamDto;
import com.darren1112.dwr.spi.openapi.result.QingYunKeResultDto;

/**
 * api远程调用类
 *
 * @author darren
 * @since 2023/02/18
 */
public interface OpenApiRemoting {

    /**
     * 请求青云客openApi
     *
     * @param param 请求参数
     * @return {@link QingYunKeResultDto}
     * @author darren
     * @since 2023/02/18
     */
    QingYunKeResultDto requestQingYunKeOpenApi(QingYunKeParamDto param) throws RemotingException;
}
