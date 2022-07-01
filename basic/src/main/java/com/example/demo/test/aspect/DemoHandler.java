package com.example.demo.test.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * aop方法拦截
 * @author chenlingl
 */
public class DemoHandler implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //获取方法
        Method method = methodInvocation.getMethod();
        //获取请求参数
        Object[] arguments = methodInvocation.getArguments();
        //
        return methodInvocation.proceed();
    }
}
