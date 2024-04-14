package com.capgemini.commons.response;

import com.capgemini.commons.constants.HttpStatus;
import com.capgemini.commons.exception.BaseException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-20:56
 * @Description:统一返回对象
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "API 响应内容")
@SuppressWarnings("unused")
public class Response<T> {

    /**
     * 请求状态码
     */
    @Schema(description = "API 响应 code")
    private Integer code;

    /**
     * 请求结果说明
     */
    @Schema(description = "API 响应结果描述说明")
    private String message;

    /**
     * 请求结果
     */
    @Schema(description = "API 响应数据")
    private T data;

    /**
     * 正常返回数据
     *
     * @param data 返回数据
     * @return Response
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMsg(), data);
    }

    /**
     * 处理void返回值场景
     *
     * @return Response
     */
    public static Response<Void> success() {
        return success(null);
    }

    /**
     * 返回异常信息
     *
     * @param status Status
     * @return Response
     */
    public static Response<Void> fail(HttpStatus status) {
        return fail(status, status.getMsg());
    }

    /**
     * 返回异常信息
     *
     * @param code    code
     * @param message 错误信息
     * @return Response
     */
    public static Response<Void> fail(int code, String message) {
        return new Response<>(code, message, null);
    }

    /**
     * 返回异常信息
     *
     * @param status  Status
     * @param message 错误信息
     * @return Response
     */
    public static Response<Void> fail(HttpStatus status, String message) {
        return new Response<>(status.getCode(), message, null);
    }

    /**
     * 错误返回
     *
     * @param baseException 异常
     * @return Response
     */
    public static Response<Void> fail(BaseException baseException) {
        return new Response<>(baseException.getCode(), baseException.getMessage(), null);
    }
}


