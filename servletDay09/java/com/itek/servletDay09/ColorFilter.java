package com.itek.servletDay09;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebFilter(filterName = "ColorFilter")
public class ColorFilter implements Filter {
    public void destroy() {
    }
    long time1 = System.currentTimeMillis();
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String color = req.getParameter("color");
        if (color == "red"){
            resp.getWriter().write("What a happy color!");
        }
        chain.doFilter(req, resp);
    }
    long time2 = System.currentTimeMillis();
    public void init(FilterConfig config) throws ServletException {

    }

}
