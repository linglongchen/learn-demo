package com.example.demo.spring;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/11 16:22
 */
public class TestInjectFilter implements Filter {

    @Resource
    private TestService testService;

    private String string;

    private String string2;

    public TestInjectFilter(String s, String s1) {
        this.string = s;
        this.string2 = s1;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        testService.exec(string);
    }
}
