package com.example.demo.designPattern.observer;

import java.util.EventObject;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/30 16:01
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
