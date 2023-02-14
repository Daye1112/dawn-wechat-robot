package com.darren1112.dwr.common.remoting.base;

import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.util.StringUtil;

/**
 * 单对象响应处理类
 *
 * @author darren
 * @since 2021/4/25 17:18
 */
public abstract class BaseSimpleRemotingHandler {

    protected static final String DEFAULT_BLANK_MESSAGE = "响应结果为空";

    protected String result;

    protected BaseSimpleRemotingHandler(String result) {
        this.result = result;
    }

    /**
     * 空值校验
     *
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:07
     */
    public void blankValidate() {
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
     * @param clazz 类型
     * @return 转换对象
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:13
     */
    public abstract <T> T convertTo(Class<T> clazz) throws RemotingException;

    /**
     * 响应结果校验
     *
     * @param t 校验对象
     * @return 返回类型
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2020/12/24 11:06
     */
    public abstract <T> void resultValidate(T t) throws RemotingException;

}
