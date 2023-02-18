package com.darren1112.dwr.common.base;

/**
 * 基础bean-接口类
 *
 * @author darren
 * @since 2023/02/12
 */
public interface BaseBean {

    /**
     * 初始方法
     *
     * @throws Exception 异常
     * @author darren
     * @since 2022/01/15
     */
    void init() throws Exception;

    /**
     * 销毁方法
     *
     * @author darren
     * @since 2022/01/15
     */
    void destroy();
}
