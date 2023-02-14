package com.darren1112.dwr.common.enums;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import org.springframework.http.HttpStatus;

/**
 * 通用异常枚举
 *
 * @author darren
 * @since 2023/2/14
 */
public enum CommonErrorEnum implements BaseErrorEnum {

    /**
     * 异常枚举
     */
    REMOTING_ERROR(HttpStatus.BAD_REQUEST, "远程调用异常");

    /**
     * 异常code
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    CommonErrorEnum(HttpStatus httpStatus, String message) {
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
