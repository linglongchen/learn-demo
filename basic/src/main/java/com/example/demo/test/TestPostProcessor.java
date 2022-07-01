package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/12/23 22:15
 */
@Slf4j
@Component
public class TestPostProcessor implements BeanFactoryPostProcessor {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TestPostProcessor.class);
        builder.setInitMethodName("test");
        builder.addPropertyValue("interfaceClass", "test");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        registry.registerBeanDefinition("test",beanDefinition);
        log.info("registry test Bean!");
    }
}
