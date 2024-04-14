package com.capgemini.commons.exception;

import com.capgemini.commons.constants.HttpStatus;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:11
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.getCode(), message);
    }

}