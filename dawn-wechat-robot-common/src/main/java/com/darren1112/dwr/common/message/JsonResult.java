package com.darren1112.dwr.common.message;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回json格式
 *
 * @author darren
 * @since 2019/12/5 9:36
 */
@Data
@Accessors(chain = true)
public class JsonResult<T> implements Serializable {

    public static final Integer SUCCESS_CODE = HttpStatus.OK.value();
    public static final String SUCCESS_MESSAGE = "请求成功";

    /**
     * http状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <C> JsonResult<C> build(Integer code, String message, C data) {
        return new JsonResult<>(code, message, data);
    }

    public static <C> JsonResult<C> buildSuccess() {
        return build(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <C> JsonResult<C> buildSuccessData(C data) {
        return build(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <C> JsonResult<C> buildSuccessMsg(String message) {
        return build(SUCCESS_CODE, message, null);
    }

    public static <C> JsonResult<C> buildSuccessDataMsg(C data, String message) {
        return build(SUCCESS_CODE, message, data);
    }

    public static <C> JsonResult<C> buildErrorMsg(Integer code, String message) {
        return build(code, message, null);
    }

    public static <C> JsonResult<C> buildErrorEnum(BaseErrorEnum baseErrorEnum) {
        return build(baseErrorEnum.getCode(), baseErrorEnum.getMessage(), null);
    }
}
