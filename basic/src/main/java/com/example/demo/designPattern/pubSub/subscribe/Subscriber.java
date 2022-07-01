package com.example.demo.designPattern.pubSub.subscribe;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 17:44
 */
public interface Subscriber<T> {
    void onSubscribe(Subscription sub);
    void onNext(T item);
    void onError(Throwable ex);
    void onComplete();
}
