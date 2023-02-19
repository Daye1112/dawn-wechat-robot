package com.darren1112.dwr.sdk.starter.api.remoting.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.remoting.base.BaseRemoting;
import com.darren1112.dwr.common.util.HttpClientUtil;
import com.darren1112.dwr.common.util.JsonUtil;
import com.darren1112.dwr.sdk.starter.api.properties.OpenApiProperties;
import com.darren1112.dwr.sdk.starter.api.remoting.OpenApiRemoting;
import com.darren1112.dwr.sdk.starter.api.remoting.handler.OpenApiRemotingHandler;
import com.darren1112.dwr.spi.openapi.param.QingYunKeParamDto;
import com.darren1112.dwr.spi.openapi.result.QingYunKeResultDto;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * api远程调用类
 *
 * @author darren
 * @since 2023/02/18
 */
@Slf4j
public class OpenApiRemotingImpl extends BaseRemoting implements OpenApiRemoting {

    private HttpClientUtil httpClientUtil;

    private OpenApiProperties openApiProperties;

    public OpenApiRemotingImpl(HttpClientUtil httpClientUtil,
                               OpenApiProperties openApiProperties) {
        this.httpClientUtil = httpClientUtil;
        this.openApiProperties = openApiProperties;
    }

    /**
     * 请求青云客openApi
     *
     * @param param 请求参数
     * @return {@link QingYunKeResultDto}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2023/02/18
     */
    @Override
    public QingYunKeResultDto requestQingYunKeOpenApi(QingYunKeParamDto param) throws RemotingException {
        String result = null;
        try {
            Map<String, Object> params = JsonUtil.parseObjectByObject(param, new TypeReference<Map<String, Object>>() {
            });
            result = httpClientUtil.getForString(openApiProperties.getQingYunKeOpenApi(), params);
            return super.checkSimpleResult(new OpenApiRemotingHandler(result),
                    new TypeReference<QingYunKeResultDto>() {
                    });
        } catch (RemotingException re) {
            throw re;
        } catch (Exception e) {
            log.error("青云客openApi请求异常, result: " + result);
            throw new RemotingException("青云客openApi请求异常, result: " + result);
        }
    }

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
    @Override
    public JSONObject get(String url, Map<String, Object> params) throws RemotingException {
        String result = null;
        try {
            result = httpClientUtil.getForString(url, params);
            return super.checkSimpleResult(new OpenApiRemotingHandler(result),
                    new TypeReference<JSONObject>() {
                    });
        } catch (RemotingException re) {
            throw re;
        } catch (Exception e) {
            log.error("openApi请求异常, result: " + result);
            throw new RemotingException("openApi请求异常, result: " + result);
        }
    }

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
    @Override
    public JSONObject post(String url, Map<String, Object> params, Object obj) throws RemotingException {
        String result = null;
        try {
            result = httpClientUtil.postJsonForJson(url, obj, params);
            return super.checkSimpleResult(new OpenApiRemotingHandler(result),
                    new TypeReference<JSONObject>() {
                    });
        } catch (RemotingException re) {
            throw re;
        } catch (Exception e) {
            log.error("openApi请求异常, result: " + result);
            throw new RemotingException("openApi请求异常, result: " + result);
        }
    }
}
