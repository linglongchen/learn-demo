package com.example.demo.test.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

@Slf4j
public class TestMethodHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("before invoke method name:{}",method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        log.info("after invoke method name:{}",method.getName());
        return object;
    }

}
