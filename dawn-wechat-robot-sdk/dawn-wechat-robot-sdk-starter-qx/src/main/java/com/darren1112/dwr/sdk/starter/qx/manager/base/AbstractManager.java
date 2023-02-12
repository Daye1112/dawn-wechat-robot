package com.darren1112.dwr.sdk.starter.qx.manager.base;

import com.darren1112.dwr.common.base.BaseBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 管理者-抽象类
 *
 * @author darren
 * @since 2023/02/12
 */
public abstract class AbstractManager implements BaseBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
