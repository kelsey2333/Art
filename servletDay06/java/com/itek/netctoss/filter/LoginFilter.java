package com.itek.netctoss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对请求路径资源进行拦截
        String uri = ((HttpServletRequest)req).getRequestURI();
        System.out.println("uri:" + uri);
        if (!uri.equals("/net/login.role")&&!uri.equals("/net/check.role")&&!uri.startsWith("/net/images")&&!uri.startsWith("/net/styles")){
            //需要登录后进行拦截
        }else{
            //直接交给下一个组件
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
