package com.darren1112.dwr.common.remoting.director;

import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.remoting.base.BaseSimpleRemotingHandler;

/**
 * 简单对象返回处理指挥者
 *
 * @author darren
 * @since 2021/4/25 17:31
 */
public class SimpleRemotingHandlerDirector {

    /**
     * 处理类
     */
    private BaseSimpleRemotingHandler baseSimpleRemotingHandler;

    public SimpleRemotingHandlerDirector(BaseSimpleRemotingHandler baseSimpleRemotingHandler) {
        this.baseSimpleRemotingHandler = baseSimpleRemotingHandler;
    }

    /**
     * 简单对象处理
     *
     * @param clazz 类型
     * @return {@link T 泛型对象}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2021/4/25 19:18
     */
    public <T> T simpleHandle(Class<T> clazz) throws RemotingException {
        // 空值校验
        baseSimpleRemotingHandler.blankValidate();
        // 结果预校验
        baseSimpleRemotingHandler.preValidate();
        // 类型转换
        T t = baseSimpleRemotingHandler.convertTo(clazz);
        // 结果校验
        baseSimpleRemotingHandler.resultValidate(t);
        return t;
    }
}
