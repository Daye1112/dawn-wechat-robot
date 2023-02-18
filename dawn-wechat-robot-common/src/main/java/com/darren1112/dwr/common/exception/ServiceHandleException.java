package com.darren1112.dwr.common.exception;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import lombok.Getter;

/**
 * 业务处理异常
 *
 * @author darren
 * @since 2021/12/6
 */
@Getter
public class ServiceHandleException extends BaseException {

    public ServiceHandleException(String msg) {
        super(msg);
    }

    public ServiceHandleException(Integer status, String message) {
        super(status, message);
    }

    public ServiceHandleException(BaseErrorEnum baseErrorEnum) {
        super(baseErrorEnum);
    }
}
