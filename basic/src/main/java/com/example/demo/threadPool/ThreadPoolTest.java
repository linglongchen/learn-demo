package com.example.demo.threadPool;

import java.util.concurrent.*;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/26 10:35
 */
public class ThreadPoolTest {

    public void testThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        executor.execute(new TestThread());
    }

    static class TestThread implements Runnable {

        @Override
        public void run() {
            System.out.println(111);
        }
    }

    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.testThreadPool();
    }
}
