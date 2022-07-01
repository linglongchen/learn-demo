package com.example.demo.trace;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author chenlingl
 */
public class TraceLogUtils {

    public static String traceId;

    public static String getTraceId(){
        return String.valueOf(RandomUtils.nextLong());
    }
}
