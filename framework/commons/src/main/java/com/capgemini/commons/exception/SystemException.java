package com.capgemini.commons.exception;

import static com.capgemini.commons.constants.HttpStatus.SYSTEM_ERROR;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:12
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public class SystemException extends BaseException {

    public SystemException(String message) {
        this(message, null);
    }

    public SystemException(Throwable cause) {
        this(SYSTEM_ERROR.getMsg(), cause);
    }

    public SystemException(String message, Throwable cause) {
        super(SYSTEM_ERROR.getCode(), message, cause);
    }
}
