package com.example.demo.callback;

public class CallbackImpl {

    public void testTime(CallBack callBack) {
        //业务处理逻辑
        long begin = System.currentTimeMillis();
        //进行回调操作
        long end = System.currentTimeMillis();
        //测试结束时间
        System.out.println("==========[use time]:" + (end - begin));

        //处理结束进行回调
        callBack.execute();
    }

    public static void main(String[] args) {
        CallbackImpl tool = new CallbackImpl();
        tool.testTime(new CallBack() {
            @Override
            public void execute() {
                //回调函数业务处理
                System.out.println("================回调函数业务处理===================");
            }
        });

    }
}
