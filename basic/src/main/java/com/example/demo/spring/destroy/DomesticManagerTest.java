package com.example.demo.spring.destroy;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

/**
* DomesticManager Tester. 
* 
* @author chenlingl
* @since <pre>12/03/2021</pre>
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class DomesticManagerTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception {

    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            super.starting(description);
            log.info("<<<<<<<开始执行测试：{}", description.getMethodName());
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            log.info("{}执行完毕>>>>>>>", description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            log.error("-----方法执行失败，异常:{}", e.getMessage());
        }
    };


    @Test
    public void testHandleTransport() throws Exception { 
        //TODO: Test goes here...
        applicationContext.publishEvent(new CustomEvent(applicationContext));
    }
}
