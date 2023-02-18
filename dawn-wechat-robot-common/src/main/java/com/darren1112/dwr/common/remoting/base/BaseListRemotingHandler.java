package com.darren1112.dwr.common.remoting.base;

import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.util.StringUtil;

import java.util.List;

/**
 * 集合响应处理类
 *
 * @author darren
 * @since 2021/4/25 17:17
 */
public abstract class BaseListRemotingHandler {

    protected static final String DEFAULT_BLANK_MESSAGE = "响应结果为空";

    protected String result;

    protected BaseListRemotingHandler(String result) {
        this.result = result;
    }

    /**
     * 空值校验
     *
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:07
     */
    public void blankValidate() throws RemotingException {
        if (StringUtil.isBlank(result)) {
            throw new RemotingException(DEFAULT_BLANK_MESSAGE);
        }
    }

    /**
     * 钩子函数-结果预校验
     *
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2021/12/29
     */
    public void preValidate() throws RemotingException {

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
    public abstract <T> List<T> convertTo(TypeReference<T> typeReference) throws RemotingException;

    /**
     * 响应结果校验
     *
     * @param tList 校验对象
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:06
     */
    public abstract <T> void resultValidate(List<T> tList) throws RemotingException;
}
