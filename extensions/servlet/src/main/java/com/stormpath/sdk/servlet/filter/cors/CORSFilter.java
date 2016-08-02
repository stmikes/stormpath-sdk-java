package com.stormpath.sdk.servlet.filter.cors;

import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.servlet.authz.RequestAuthorizer;
import com.stormpath.sdk.servlet.filter.HttpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter extends HttpFilter {

    private static final Logger log = LoggerFactory.getLogger(CORSFilter.class);
    private RequestAuthorizer originRequestAuthorizer;

    public void setOriginRequestAuthorizer(RequestAuthorizer originRequestAuthorizer) {
        this.originRequestAuthorizer = originRequestAuthorizer;
    }

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws Exception {

        try {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        } catch (Exception e) {
            log.error("Specified Origin '{}' is not allowed: {}", request.getHeader("Origin"), e.getMessage(), e);
        }

        chain.doFilter(request, response);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        Assert.notNull(this.originRequestAuthorizer, "originRequestAuthorizer cannot be null.");
    }
}
