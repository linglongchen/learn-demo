package com.example.demo.designPattern.listener;

import com.example.demo.designPattern.observer.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 6/23/2022 10:02 PM
 */
@Component
public class IEventListener implements ApplicationListener<IEvent> {

    @Override
    public void onApplicationEvent(IEvent event) {
        System.out.println("我监听了消息！");
    }
}
