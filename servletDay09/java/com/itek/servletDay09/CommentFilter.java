package com.itek.servletDay09;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CommentFilter",urlPatterns = "/comment")
public class CommentFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 代码1
        System.out.println("service执行之前");

        // 拦截请求参数
        String comment = req.getParameter("comment");

        // 判断提交的内容是否有敏感词
        if (comment.indexOf("不") != -1) {
            // 直接返回客户端内容
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("您发表的啥内容,心里还没点数么?");
            return;

            // 文字替换
//            comment.replaceAll("不", "**");
        }

//        System.out.println("filter1 before =====================");
        System.out.println("time before filter"+ System.currentTimeMillis());
        // 先执行代码1, 将请求转交给下一个web组件, 当下一个组件执行完毕之后,在继续执行代码2
        chain.doFilter(req, resp); // service
//        System.out.println("filter1 after =====================");
        System.out.println("time after filter"+ System.currentTimeMillis());

        // 代码2
        System.out.println("service执行之后");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
