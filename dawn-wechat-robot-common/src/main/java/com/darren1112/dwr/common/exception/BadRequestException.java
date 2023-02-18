package com.darren1112.dwr.common.exception;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import lombok.Getter;

/**
 * 客户端请求错误异常
 *
 * @author darren
 * @since 2019/12/7 10:52
 */
@Getter
public class BadRequestException extends BaseException {

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(Integer status, String message) {
        super(status, message);
    }

    public BadRequestException(BaseErrorEnum baseErrorEnum) {
        super(baseErrorEnum);
    }
}
