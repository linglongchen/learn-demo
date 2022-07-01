package com.example.demo.designPattern.listener;

import com.example.demo.designPattern.observer.ApplicationEvent;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 6/23/2022 10:02 PM
 */
public class IEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public IEvent(Object source) {
        super(source);
    }
}
