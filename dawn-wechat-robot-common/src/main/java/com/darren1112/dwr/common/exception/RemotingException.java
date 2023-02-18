package com.darren1112.dwr.common.exception;

import com.darren1112.dwr.common.exception.enums.BaseErrorEnum;
import lombok.Getter;

/**
 * 远程调用异常
 *
 * @author darren
 * @since 2021/12/6
 */
@Getter
public class RemotingException extends BaseException {

    public RemotingException(String msg) {
        super(msg);
    }

    public RemotingException(Integer status, String message) {
        super(status, message);
    }

    public RemotingException(BaseErrorEnum baseErrorEnum) {
        super(baseErrorEnum);
    }
}
