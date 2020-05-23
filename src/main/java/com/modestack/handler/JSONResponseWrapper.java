package com.modestack.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages="com.modestack")
public class JSONResponseWrapper implements ResponseBodyAdvice<Object>
{
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType)
    {
        return true;
    }
    
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response)
    {
        if (body instanceof ApiResponseBody)
        {
            return body;
        }
        int status = ((ServletServerHttpResponse)response).getServletResponse().getStatus();
        ApiResponseBody apiResponseBody = new ApiResponseBody(String.valueOf(status));
        apiResponseBody.setData(body);
        return apiResponseBody;
    }
}