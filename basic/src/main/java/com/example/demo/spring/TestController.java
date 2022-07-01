package com.example.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/11 16:26
 */
@RestController
public class TestController {



    @GetMapping(value = "test")
    public void test() {

    }
}
