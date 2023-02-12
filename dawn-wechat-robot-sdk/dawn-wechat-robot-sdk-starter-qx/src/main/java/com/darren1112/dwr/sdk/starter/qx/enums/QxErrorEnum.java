package com.darren1112.dwr.sdk.starter.qx.enums;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import org.springframework.http.HttpStatus;

/**
 * 千寻-异常枚举
 *
 * @author darren
 * @since 2023/02/12
 */
public enum QxErrorEnum implements BaseErrorEnum {

    /**
     * 异常信息
     */
    EVENT_HANDLER_NOT_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "事件处理器不存在");

    /**
     * 异常code
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    QxErrorEnum(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.message = message;
    }

    /**
     * 异常code
     *
     * @return {@link Integer)
     * @author darren
     * @since 2021/12/5
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * 异常信息
     *
     * @return {@link String)
     * @author darren
     * @since 2021/12/5
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
