package com.example.demo.designPattern.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 6/23/2022 10:34 PM
 */
@RunWith(SpringRunner.class)
public class EventTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testListener() {
        applicationContext.publishEvent(new IEvent(applicationContext));
    }
}
