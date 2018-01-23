package com.lance.blog.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter for test
 *
 * @author Lance
 * @date 2018/1/19 15:06
 */
public class CORSFilter implements Filter {

    private FilterConfig filterConfig;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Hello CORSFilter");

        new TestFilter().doFilter(request, response, chain);
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
