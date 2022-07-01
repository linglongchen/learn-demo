package com.example.demo.filter;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 19:42
 */
public interface BaseFilterChain {
    Object doFilter(Object obj);
}
