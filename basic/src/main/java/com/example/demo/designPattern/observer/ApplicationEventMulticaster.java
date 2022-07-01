package com.example.demo.designPattern.observer;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/30 16:05
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> applicationListener);

    void removeApplicationListener(ApplicationListener<?> applicationListener);

    void multicastEvent(ApplicationEvent event);
}
