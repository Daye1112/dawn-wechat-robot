package com.darren1112.dwr.sdk.starter.api.remoting.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.constants.ResponseConstant;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.remoting.base.BaseSimpleRemotingHandler;
import com.darren1112.dwr.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 机器人api远程调用处理器
 *
 * @author darren
 * @since 2023/2/14
 */
@Slf4j
public class OpenApiRemotingHandler extends BaseSimpleRemotingHandler {

    public OpenApiRemotingHandler(String result) {
        super(result);
    }

    /**
     * 响应转换
     *
     * @param typeReference 类型
     * @return 转换对象
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:13
     */
    @Override
    public <T> T convertTo(TypeReference<T> typeReference) throws RemotingException {
        try {
            return JsonUtil.parseObject(this.result, typeReference);
        } catch (RemotingException re) {
            throw re;
        } catch (Exception e) {
            throw new RemotingException("机器人api远程调用响应类型异常, result: " + this.result);
        }
    }

    /**
     * 响应结果校验
     *
     * @param t 校验对象
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:06
     */
    @Override
    public <T> void resultValidate(T t) throws RemotingException {

    }
}
