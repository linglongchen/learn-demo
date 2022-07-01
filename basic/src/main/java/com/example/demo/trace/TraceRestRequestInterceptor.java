package com.example.demo.trace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Objects;


/**
 * @author chenlingl
 */
public class TraceRestRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Log log = LogFactory.getLog(TraceRestRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        try {
            String traceId = MDC.get(Constants.LOG_TRACE_ID);

            if (Objects.nonNull(traceId)) {
                request.getHeaders().add(Constants.LOG_TRACE_ID, traceId);
                if (log.isDebugEnabled()) {
                    log.debug("Request Url :" + request.getURI().toURL().toString() + " add traceId: " + traceId + "to head");
                }
            }
            return execution.execute(request, body);
        } finally {

        }
    }
}
