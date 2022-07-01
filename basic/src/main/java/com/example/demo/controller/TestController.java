package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/28 9:09
 */
@RestController
@RequestMapping
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "123";
    }
}
