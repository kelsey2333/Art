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
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListEmpServlet", urlPatterns = "/list/emp")
public class ListEmpServlet extends HttpServlet {
    private EmpDao empDao = new EmpDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Emp> emps = empDao.selectAll();
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>员工列表页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <table>\n" +
                "        <thead>\n" +
                "            <tr>\n" +
                "                <th>id</th>\n" +
                "                <th>name</th>\n" +
                "                <th>sal</th>\n" +
                "                <th>age</th>\n" +
                "                <th>oper</th>\n" +
                "            </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n");

        for (Emp emp : emps) {
            sb.append("<tr>\n" +
                    "<td>" + emp.getId() + "</td>\n" +
                    "<td>" + emp.getName() + "</td>\n" +
                    "<td>" + emp.getSal() + "</td>\n" +
                    "<td>" + emp.getAge() + "</td>\n" +
                    " <td><a href ='http://localhost:8080/servletDay02/del/emp?id="+ emp.getId() +"'><input type='button' value='删除'></td></a>"+
                    " <td><a href ='http://localhost:8080/servletDay02/html/modEmp.html?id="+ emp.getId() +"&username=" + emp.getName() +"&sal="+ emp.getSal()+"&age="+emp.getAge()+"'><input type='button' value='修改'></td></a>"+
                    " </tr>");
        }

        sb.append("</tbody></table></body></html>");
        resp.setContentType("text/html;charset=utf-8");
        //将表中数据返回给客户端
        PrintWriter pw = resp.getWriter();
        pw.write(sb.toString());
    }
}
