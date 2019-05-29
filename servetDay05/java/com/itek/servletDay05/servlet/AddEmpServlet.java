/**
 * @Author wpzhang
 * @Date 2019/5/28
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
 * @create: 2019-05-28 18:47
 **/
@WebServlet(name = "AddEmpServlet",urlPatterns = "/add/emp")
public class AddEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        req.setCharacterEncoding("utf-8");
        String name =  req.getParameter("name");
        String job = req.getParameter("job");
        System.out.println(name);
        System.out.println(job);

        EmpDao empDao = new EmpDaoImpl();
        empDao.addEmp(new Emp(null,name,job));

        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("/servletDay05/jsp/listEmp.jsp");

    }
}