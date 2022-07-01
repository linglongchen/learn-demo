package com.alibaba.nacos.example.spring.cloud.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/29 9:59
 */
@RestController
@RequestMapping("/server1")
public class TestController {

    @GetMapping("/test")
    public String test(String msg) {
        return msg;
    }
}
