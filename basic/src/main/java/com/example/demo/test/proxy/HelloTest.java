package com.example.demo.test.proxy;

import java.lang.reflect.Proxy;

public class HelloTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ProxyHandler proxyHandler = new ProxyHandler(helloService);
        HelloService proxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(),proxyHandler);
        proxy.invocation();
    }
}
