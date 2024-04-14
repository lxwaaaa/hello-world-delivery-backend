package com.capgemini.web.core;

import com.capgemini.commons.response.Response;
import java.lang.reflect.Method;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:15
 * @Description:全局响应结果（ResponseBody）处理器方便 {@link Response} 记录访问日志
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@ControllerAdvice
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Response<?>> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Method method = returnType.getMethod();
        if (method == null) {
            return false;
        }
        // 只拦截返回结果为 Response 类型
        return method.getReturnType() == Response.class;
    }

    @Override
    public Response<?> beforeBodyWrite(Response<?> body, MethodParameter returnType, MediaType selectedContentType,
                                       Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                       ServerHttpRequest request,
                                       ServerHttpResponse response) {
        return body;
    }
}
