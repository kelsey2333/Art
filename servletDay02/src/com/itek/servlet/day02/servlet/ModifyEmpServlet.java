package com.itek.servlet.day02.servlet;

import com.itek.servlet.day02.dao.EmpDao;
import com.itek.servlet.day02.dao.impl.EmpDaoImpl;
import com.itek.servlet.day02.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
   1、点击修改按钮就会跳转到/html/modEmp.html界面
   2、在html界面修改好后跳转到/list/emp&xxxx&xxxx&xxxx界面(此处用get方法可以在地址栏看到name:value键值对)
      /mod/emp里只做两件事：-调用修改的方法修改数据库中数据。
                            -list修改后的数据

 */
@WebServlet(name = "ModifyEmpServlet",urlPatterns = "/mod/emp")
public class ModifyEmpServlet extends HttpServlet {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String sal =  req.getParameter("sal");
        String age =  req.getParameter("age");
        System.out.println(username);
        System.out.println(sal);
        System.out.println(age);

        //将数据修改
        EmpDao empDao = new EmpDaoImpl();
        empDao.modify(new Emp(Integer.parseInt(id),username,Double.parseDouble(sal),Integer.parseInt(age)));

        resp.sendRedirect("/servletDay02/jsp/listEmp.jsp");
        resp.setContentType("text/html;charset=utf-8");
    }
}
