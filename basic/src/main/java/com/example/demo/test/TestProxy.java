package com.example.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.InstantiationStrategy;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/12/23 22:39
 */
@Component
public class TestProxy implements InstantiationStrategy {
    @Override
    public Object instantiate(RootBeanDefinition rootBeanDefinition, String s, BeanFactory beanFactory) throws BeansException {
        return null;
    }

    @Override
    public Object instantiate(RootBeanDefinition rootBeanDefinition, String s, BeanFactory beanFactory, Constructor<?> constructor, Object... objects) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootBeanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        return enhancer.create(constructor.getParameterTypes(),objects);
    }

    @Override
    public Object instantiate(RootBeanDefinition rootBeanDefinition, String s, BeanFactory beanFactory, Object o, Method method, Object... objects) throws BeansException {
        return null;
    }
}
