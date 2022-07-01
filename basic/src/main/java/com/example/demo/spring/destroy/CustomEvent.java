package com.example.demo.spring.destroy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/29 22:52
 */
@Component
public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(ApplicationContext source) {
        super(source);
    }
}
