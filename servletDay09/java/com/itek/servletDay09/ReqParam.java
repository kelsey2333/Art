/**
 * @Author wpzhang
 * @Date 2019/6/3
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
 * @create: 2019-06-03 14:42
 **/
@WebServlet(name = "ReqParam",urlPatterns = "/reqParam")
public class ReqParam extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.getParameter("color");
        req.getRequestURI();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("请求监听。。。。");
    }
}