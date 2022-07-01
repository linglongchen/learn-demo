package com.example.demo.spring.destroy;


import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/29 22:54
 */
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到:"+event.getSource() + "消息;时间："+new Date());
    }
}
