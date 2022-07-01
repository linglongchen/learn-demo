package com.example.demo.test.proxy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloServiceImpl implements HelloService{
    @Override
    public void invocation() {
        log.info("===============执行代理处理=============");
    }
}
