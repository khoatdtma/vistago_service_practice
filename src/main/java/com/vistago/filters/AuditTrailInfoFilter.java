package com.vistago.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class AuditTrailInfoFilter implements Filter {
    public static final Logger LOGGER = LoggerFactory.getLogger(AuditTrailInfoFilter.class);
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Perform auditTrailInfo filter ...");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
