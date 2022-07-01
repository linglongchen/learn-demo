package com.example.demo.test.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestService {

    public String sayHi(String name) {
      log.info("业务实现逻辑");
      return "业务";
    }
}
