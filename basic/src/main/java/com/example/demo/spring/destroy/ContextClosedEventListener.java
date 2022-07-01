package com.example.demo.spring.destroy;


import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/29 23:04
 */
@Component
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName()+"时间："+System.currentTimeMillis());
//        Thread.sleep(10000);
    }
}
