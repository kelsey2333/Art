/**
 * @Author wpzhang
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servletDay09;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDAY09
 * @description:
 * @author: wpzhang
 * @create: 2019-06-04 05:29
 **/
@WebServlet(name = "CommonServlet",urlPatterns = "/comment")
public class CommonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        //
        req.setCharacterEncoding("UTF-8");

        System.out.println("service 正在执行");

        // 获取提交过来的评论
        String comment = req.getParameter("comment");

        //
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().println("您发表的评论<font color='red'>'" + comment + "'</font>已经发表成功");
    }
}