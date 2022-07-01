package com.example.demo.designPattern.observer;

import java.util.EventListener;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/30 16:06
 */
public interface ApplicationListener  <E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
