package com.example.demo;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Created by ds on 2019-05-26 오후 7:48.
 */
public class TestRequestMappingHandlerAdapter extends RequestMappingHandlerMapping {
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        return super.getMappingForMethod(method, handlerType);
    }
}