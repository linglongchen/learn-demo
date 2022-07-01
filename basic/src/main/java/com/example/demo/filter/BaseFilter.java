package com.example.demo.filter;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 19:41
 */
public interface BaseFilter {
    Object doFilter(Object obj,BaseFilterChain filterChain);
}
