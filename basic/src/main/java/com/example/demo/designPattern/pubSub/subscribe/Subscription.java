package com.example.demo.designPattern.pubSub.subscribe;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 17:44
 */
public interface Subscription {
    void request(long n);
    void cancel();
}
