/**
 * @Author wpzhang
 * @Date 2019/5/27
 * @Description
 */
package com.itek.servlet.day04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay04
 * @description:
 * @author: wpzhang
 * @create: 2019-05-27 15:15
 **/
@WebServlet(name = "Servlet3",urlPatterns = "/Servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servlet上下文
        ServletContext context = getServletContext();
        //绑定数据
        if (context.getAttribute("totalcount") == null){
            context.setAttribute("totalcount",0);
        }
        int totalcount = (Integer)context.getAttribute("totalcount");
        totalcount++;
        //重新设置totalcount
        context.setAttribute("totalcount",totalcount);
        System.out.println("当前访问servlet的次数为："+totalcount);
    }
}