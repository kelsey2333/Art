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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddEmpServlet",urlPatterns = "/add/emp")
public class AddEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置参数的编码格式
        req.setCharacterEncoding("utf-8");
        //接收浏览器端的参数
        String username = req.getParameter("username");
        String sal = req.getParameter("sal");
        String age = req.getParameter("age");
        System.out.println(sal);
        System.out.println(age);
        System.out.println(username);

        //将数据保存起来到数据库
        EmpDao empDao = new EmpDaoImpl();
        empDao.addEmp(new Emp(null,username,Double.parseDouble(sal),Integer.parseInt(age)));
        //返回设置数据的编码格式
        resp.setContentType("text/html;charset=utf-8");
        //返回客户端的数据给浏览器
        resp.sendRedirect("/servletDay02/list/emp");
    }
}
