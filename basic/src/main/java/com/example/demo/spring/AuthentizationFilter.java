package com.example.demo.spring;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v_vllchen
 */
public class AuthentizationFilter extends BasicAuthenticationFilter {

    @Resource
    private TestService testService;

    private String string;





    public AuthentizationFilter(AuthenticationManager authenticationManager, String string) {
        super(authenticationManager);
        this.string = string;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
