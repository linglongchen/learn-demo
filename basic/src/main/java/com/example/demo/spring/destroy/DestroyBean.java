package com.example.demo.spring.destroy;


import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/12/10 18:10
 */
@Component
public class DestroyBean {

    @PreDestroy
    public void destroyBean() {
        System.out.println("销毁bean！ by @PreDestroy!时间戳:"+System.currentTimeMillis());
    }
}
