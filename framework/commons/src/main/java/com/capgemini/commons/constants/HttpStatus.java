package com.capgemini.commons.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-20:49
 * @Description:状态码
 */

@Getter
@AllArgsConstructor
public enum HttpStatus {

    SUCCESS(200, "操作成功"),

    /**
     * 业务异常
     * 默认 code 为 299, message 为实际业务异常描述
     * 如果前端需要有根据 code 做特殊逻辑处理的，定义特殊业务异常，code 为 300～399,不建议状态码乱定义哦：）
     * 举例：前端给我的数据不符合要求，可以使用这个。或者也可以简单理解为查询详情，但是这个id已经不存在了。
     */
    BUSINESS_ERROR(299, "业务异常"),

    /**
     * 减少代码冗余
     * 直接在DTO或者Controller中使用注解校验，到时候我会用拦截器拦截
     */
    BAD_REQUEST(400, "请求参数异常"),

    NOT_FOUNT(404, "资源不存在"),

    /**
     * 简而言之，Get方法用Put去请求
     */
    METHOD_NOT_ALLOWED(405, "请求方法不正确"),

    /**
     * 系统方面的异常，比如空指针等操作
     */
    SYSTEM_ERROR(500, "系统异常");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态信息
     */
    private final String msg;
}
