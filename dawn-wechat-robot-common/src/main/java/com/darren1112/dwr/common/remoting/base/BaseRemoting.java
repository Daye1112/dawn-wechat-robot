package com.darren1112.dwr.common.remoting.base;

import com.darren1112.dwr.common.remoting.director.ListRemotingHandlerDirector;
import com.darren1112.dwr.common.remoting.director.SimpleRemotingHandlerDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 远程调用基础类
 *
 * @author darren
 * @since 2022/7/12
 */
public abstract class BaseRemoting {

    /**
     * 响应结果校验
     *
     * @param handler 响应处理器
     * @param clazz   转换对象类型
     * @return 转换结果
     * @author darren
     * @since 2020/12/24 13:32
     */
    public <T> T checkSimpleResult(BaseSimpleRemotingHandler handler, Class<T> clazz) {
        return new SimpleRemotingHandlerDirector(handler).simpleHandle(clazz);
    }

    /**
     * 响应结果校验
     *
     * @param handler 响应处理器
     * @param clazz   转换对象类型
     * @return 转换结果
     * @author darren
     * @since 2020/12/24 13:32
     */
    public <T> List<T> checkListResult(BaseListRemotingHandler handler, Class<T> clazz) {
        return new ListRemotingHandlerDirector(handler).simpleHandle(clazz);
    }

    /**
     * 构建json请求header
     *
     * @return {@link Map 默认请求头}
     * @author darren
     * @since 2021/1/4 21:24
     */
    public Map<String, String> createJsonPostHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        return header;
    }
}
