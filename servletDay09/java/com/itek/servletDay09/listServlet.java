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
 * @create: 2019-06-03 14:55
 **/
@WebServlet(name = "listServlet",urlPatterns = "/list")
public class listServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/WEB-INF/jsp/color.jsp").forward(req,resp);
        resp.setContentType("text/html;charset=utf-8");
    }
}