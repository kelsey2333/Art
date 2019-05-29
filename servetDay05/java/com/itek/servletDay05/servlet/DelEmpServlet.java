/**
 * @Author wpzhang
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servletDay05.servlet;

import com.itek.servletDay05.dao.EmpDao;
import com.itek.servletDay05.dao.Impl.EmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay05
 * @description:
 * @author: wpzhang
 * @create: 2019-05-28 22:45
 **/
@WebServlet(name = "DelEmpServlet",urlPatterns = "/del/emp")
public class DelEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String deptno = req.getParameter("deptno");
        EmpDao empDao = new EmpDaoImpl();
        empDao.delEmp(Integer.parseInt(deptno));
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("/servletDay05/jsp/listEmp.jsp");
    }
}