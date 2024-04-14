package com.capgemini.commons.exception;

import com.capgemini.commons.constants.HttpStatus;
import lombok.Getter;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-20:54
 * @Description:基础异常，防止集成第三方文件异常无法捕捉
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public abstract class BaseException extends RuntimeException {

    @Getter
    protected final int code;

    BaseException(HttpStatus httpStatus) {
        this(httpStatus.getCode(), httpStatus.getMsg(), null);
    }

    BaseException(int code, String message) {
        this(code, message, null);
    }

    BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
