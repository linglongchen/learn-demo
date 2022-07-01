package com.example.demo.test.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class Test {
    public static void main(String[] args) {
        log.info("执行cglib动态代理！");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestService.class);
        enhancer.setCallback(new TestMethodHandler());
        TestService proxy = (TestService) enhancer.create();
        proxy.sayHi("执行代理！");
    }
}
