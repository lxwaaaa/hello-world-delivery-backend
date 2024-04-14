package com.capgemini.web.core;

import cn.hutool.core.lang.Assert;
import com.capgemini.commons.constants.HttpStatus;
import com.capgemini.commons.exception.BadRequestException;
import com.capgemini.commons.exception.BaseException;
import com.capgemini.commons.exception.SystemException;
import com.capgemini.commons.response.Response;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:10
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String BAD_REQUEST_MESSAGE_TEMPLATE = "请求参数不正确:%s";


    /**
     * 处理 SpringMVC 请求参数缺失
     * 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Response<Void> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
        return Response.fail(new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, ex.getParameterName())));
    }

    /**
     * 处理 SpringMVC 请求参数类型错误
     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response<Void> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
        return Response.fail(new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, ex.getMessage())));
    }

    /**
     * 处理 SpringMVC 参数校验不正确
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Void> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        log.warn("[methodArgumentNotValidExceptionExceptionHandler]", ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        Assert.isTrue(fieldError != null, "断言，避免告警");
        assert fieldError != null;
        return Response.fail(
            new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, fieldError.getDefaultMessage())));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ExceptionHandler(BindException.class)
    public Response<Void> bindExceptionHandler(BindException ex) {
        log.warn("[handleBindException]", ex);
        FieldError fieldError = ex.getFieldError();
        Assert.isTrue(fieldError != null, "断言，避免告警");
        assert fieldError != null;
        return Response.fail(
            new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, fieldError.getDefaultMessage())));
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response<Void> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.warn("[constraintViolationExceptionHandler]", ex);
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return Response.fail(
            new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, constraintViolation.getMessage())));
    }


    /**
     * 处理自定义异常 BaseException
     * 例如说，商品库存不足，用户手机号已存在。
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Response<Void> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
        log.warn("[httpMessageNotReadableExceptionHandler]", ex);
        return Response.fail(new BadRequestException(String.format(BAD_REQUEST_MESSAGE_TEMPLATE, ex.getMessage())));
    }

    @ExceptionHandler(value = BaseException.class)
    public Response<Void> baseExceptionHandler(BaseException ex) {
        if (ex instanceof SystemException) {
            log.warn("[SystemExceptionHandler]", ex);
        } else {
            log.warn("[BaseExceptionHandler]", ex);
        }
        return Response.fail(ex);
    }

    /**
     * 处理 SpringMVC 请求地址不存在
     * 注意，它需要设置如下两个配置项：
     * 1. spring.mvc.throw-exception-if-no-handler-found 为 true
     * 2. spring.mvc.static-path-pattern 为 /statics/**
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Response<Void> noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        log.warn("[noHandlerFoundExceptionHandler]", ex);
        return Response.fail(HttpStatus.NOT_FOUNT, String.format("请求地址不存在:%s", ex.getRequestURL()));
    }

    /**
     * 处理 SpringMVC 请求方法不正确
     * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<Void> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.warn("[httpRequestMethodNotSupportedExceptionHandler]", ex);
        return Response.fail(HttpStatus.METHOD_NOT_ALLOWED, String.format("请求方法不正确:%s", ex.getMessage()));
    }


    /**
     * 处理系统异常，兜底处理所有的一切
     */
    @ExceptionHandler(value = Exception.class)
    public Response<Void> defaultExceptionHandler(Throwable ex) {
        log.error("[defaultExceptionHandler]", ex);
        // 返回 ERROR CommonResult
        return Response.fail(new SystemException(ex));
    }

}



