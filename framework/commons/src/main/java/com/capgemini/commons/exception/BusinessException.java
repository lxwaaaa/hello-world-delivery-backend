package com.capgemini.commons.exception;

import com.capgemini.commons.constants.HttpStatus;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-20:53
 * @Description:业务异常
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public class BusinessException extends BaseException {

    /**
     * 可以使用静态导入，但我没用，怕读起来浪费时间
     */
    public BusinessException(String message) {
        super(HttpStatus.BUSINESS_ERROR.getCode(), message);
    }

    // 不建议瞎搞这个方法，为了对http状态码省事才搞的这个方法
    public BusinessException(int code, String message) {
        super(code, message);
    }
}
