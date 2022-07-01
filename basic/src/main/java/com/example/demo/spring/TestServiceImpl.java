package com.example.demo.spring;

import org.springframework.stereotype.Service;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/11 16:25
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void exec(String s) {
        System.out.println("结果：" + s);
    }
}
