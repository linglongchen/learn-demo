package com.example.demo.spring.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/12/13 15:53
 */
@Component
public class DestroyBeanImpl implements InitializingBean,DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy bean by DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean by InitializingBean");
    }
}
