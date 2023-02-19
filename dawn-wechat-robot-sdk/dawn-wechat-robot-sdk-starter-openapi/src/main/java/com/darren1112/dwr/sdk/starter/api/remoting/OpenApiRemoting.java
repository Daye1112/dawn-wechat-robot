package com.darren1112.dwr.sdk.starter.api.remoting;

import com.alibaba.fastjson.JSONObject;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.spi.openapi.param.QingYunKeParamDto;
import com.darren1112.dwr.spi.openapi.result.QingYunKeResultDto;

import java.util.Map;

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
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2023/02/18
     */
    QingYunKeResultDto requestQingYunKeOpenApi(QingYunKeParamDto param) throws RemotingException;

    /**
     * get请求
     *
     * @param url    请求url
     * @param params 请求参数
     * @return {@link JSONObject}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2023/02/18
     */
    JSONObject get(String url, Map<String, Object> params) throws RemotingException;

    /**
     * post请求
     *
     * @param url    请求url
     * @param params 请求参数
     * @param obj    请求体
     * @return {@link JSONObject}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2023/02/18
     */
    JSONObject post(String url, Map<String, Object> params, Object obj) throws RemotingException;
}
