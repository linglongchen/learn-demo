package com.example.demo.test.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class ProxyHandler implements InvocationHandler {
    private Object obj;
    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("before invoke method name:{}",method.getName());
        method.invoke(obj,args);
        log.info("after invoke method name:{}",method.getName());
        return obj;
    }
}
