package com.itek.servlet.day02.servlet;

import com.itek.servlet.day02.dao.EmpDao;
import com.itek.servlet.day02.dao.impl.EmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

@WebServlet(name = "DeleteEmpServlet" ,urlPatterns = "/del/emp")
public class DeleteEmpServlet extends HttpServlet {
    private  EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String idstr = req.getParameter("id");
        //检查idstr是否是空值
        resp.setContentType("text/html;charset=utf-8");
        //todo 为什么将删除语句写在外面时必须注释掉删除语句才能执行里面的resp,否则执行不了resp。两个resp执行顺序
        if (idstr==""){
            resp.sendRedirect("/servletDay02/errors/emp");
        }else{
            //删除一条语句
            empDao.deleteById(Integer.parseInt(idstr));
            //重定向到listEmp  显示数据
            resp.sendRedirect("/servletDay02/list/emp");
        }
    }
}
