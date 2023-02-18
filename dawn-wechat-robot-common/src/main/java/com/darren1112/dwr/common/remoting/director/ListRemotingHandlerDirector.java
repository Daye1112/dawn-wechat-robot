package com.darren1112.dwr.common.remoting.director;

import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.remoting.base.BaseListRemotingHandler;

import java.util.List;

/**
 * 集合对象返回处理指挥者
 *
 * @author darren
 * @since 2021/4/25 17:31
 */
public class ListRemotingHandlerDirector {

    /**
     * 处理类
     */
    private BaseListRemotingHandler baseListRemotingHandler;

    public ListRemotingHandlerDirector(BaseListRemotingHandler baseListRemotingHandler) {
        this.baseListRemotingHandler = baseListRemotingHandler;
    }

    /**
     * 简单对象处理
     *
     * @param typeReference 类型
     * @return {@link T 泛型对象}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2021/4/25 19:18
     */
    public <T> List<T> simpleHandle(TypeReference<T> typeReference) throws RemotingException {
        // 空值校验
        baseListRemotingHandler.blankValidate();
        // 结果预校验
        baseListRemotingHandler.preValidate();
        // 类型转换
        List<T> tList = baseListRemotingHandler.convertTo(typeReference);
        // 结果校验
        baseListRemotingHandler.resultValidate(tList);
        return tList;
    }
}
