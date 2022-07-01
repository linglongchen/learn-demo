package com.example.demo.designPattern.pubSub.publish;

import com.example.demo.designPattern.pubSub.subscribe.Subscriber;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 17:43
 */
public interface Publisher<T> {
    void publish(Subscriber<? super T> subscriber);
}
