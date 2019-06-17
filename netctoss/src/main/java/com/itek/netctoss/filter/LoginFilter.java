package com.itek.netctoss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String uri = ((HttpServletRequest)req).getRequestURI();
        HttpSession session = ((HttpServletRequest) req).getSession();
        if (!"/netctoss/login.role".equals(uri)&&!"/netctoss/checkLogin.role".equals(uri)&&!"/netctoss/captcha.role".equals(uri)
            &&!uri.startsWith("/netctoss/images")&&!uri.startsWith("/netctoss/styles")){
            if (session.getAttribute("isLogin") == null){
                ((HttpServletResponse)resp).sendRedirect("/netctoss/login.role");
            }else{
                chain.doFilter(req,resp);
            }
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
