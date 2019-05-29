/**
 * @Author wpzhang
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servletDay05.servlet;

import com.itek.servletDay05.dao.EmpDao;
import com.itek.servletDay05.dao.Impl.EmpDaoImpl;
import com.itek.servletDay05.domain.Emp;

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
 * @create: 2019-05-29 06:34
 **/
@WebServlet(name = "ModEmpServlet",urlPatterns = "/mod/emp")
public class ModEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       String deptno = req.getParameter("deptno");
       String name = req.getParameter("name");
       String job = req.getParameter("job");
        System.out.println(deptno);
        System.out.println(name);
        System.out.println(job);

        EmpDao empDao = new EmpDaoImpl();
        empDao.modEmp(new Emp(Integer.parseInt(deptno),name,job));

        resp.sendRedirect("/servletDay05/jsp/listEmp.jsp");
        resp.setContentType("text/html;chsrset=utf-8");
    }
}