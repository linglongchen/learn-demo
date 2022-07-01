package com.example.demo.designPattern.observer;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/30 16:04
 */
public class ApplicationContextEvent extends ApplicationEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public ApplicationContextEvent getApplicationContextEvent() {
        return (ApplicationContextEvent) getSource();
    }
}
