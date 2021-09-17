package com.boot.boot.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


public class LocalFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Map<String, String[]> a = request.getParameterMap();

        System.out.print(a);
        HttpServletRequest re = (HttpServletRequest) request;

        System.out.print(re.getRequestURI());

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
