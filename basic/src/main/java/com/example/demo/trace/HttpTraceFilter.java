package com.example.demo.trace;


import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author chenlingl
 */
public class HttpTraceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            //获取traceId
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String traceId = httpServletRequest.getHeader(Constants.LOG_TRACE_ID);
            if (StringUtils.isBlank(traceId)) {
                //设置traceId
                traceId = String.valueOf(RandomUtils.nextLong());
            }
            MDC.put(Constants.LOG_TRACE_ID,traceId);
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            MDC.clear();
        }
    }
}
