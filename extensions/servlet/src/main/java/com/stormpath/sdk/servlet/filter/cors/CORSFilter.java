package com.stormpath.sdk.servlet.filter.cors;

import com.stormpath.sdk.servlet.authz.RequestAuthorizer;
import com.stormpath.sdk.servlet.filter.HttpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends HttpFilter {

    RequestAuthorizer stormpathOriginAccessTokenRequestAuthorizer;

    private static final Logger log = LoggerFactory.getLogger(CORSFilter.class);

    public CORSFilter() {
        log.info("SimpleCORSFilter init");
    }

    protected void filter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
            stormpathOriginAccessTokenRequestAuthorizer.assertAuthorized(request, response);

            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
//        } catch (OauthException e) {
        } catch (Exception e) {
            log.error("Specified Origin '{}' is not allowed: {}", request.getHeader("Origin"), e.getMessage(), e);
        }

        chain.doFilter(req, res);
    }

    public void onInit(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}
