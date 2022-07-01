package com.example.demo.trace;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.MDC;

import java.util.Objects;


/**
 * @author yangfeng
 */
public class FeignTraceIntercepter implements RequestInterceptor {

    private static final Log log = LogFactory.getLog(FeignTraceIntercepter.class);

    @Override
    public void apply(RequestTemplate template) {
        try {
            String traceId = MDC.get(Constants.LOG_TRACE_ID);
            if (log.isDebugEnabled()) {
                log.debug("feign request url: [" + template.url() + "] add traceId:" + traceId);
            }
            if(Objects.nonNull(traceId)){
                template.header(Constants.LOG_TRACE_ID, traceId);
            }
        } finally {

        }
    }
}
