package com.example.demo.netty;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 7/3/2022 8:54 PM
 */
public class TestDirectByteBuffer {
    private static Unsafe unsafe = null;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //分配10M的内存
        Field getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        getUnsafe.setAccessible(true);
        unsafe = (Unsafe)getUnsafe.get(null);
        long address = unsafe.allocateMemory(10 * 1024 * 1024);
        unsafe.freeMemory(address);
    }
}
