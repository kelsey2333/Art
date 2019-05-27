package com.itek.servlet.day02.servlet;

import com.itek.servlet.day02.dao.EmpDao;
import com.itek.servlet.day02.dao.impl.EmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorServlet", urlPatterns = "/errors/emp")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw  new RuntimeException("缺少必要参数");
    }
}
