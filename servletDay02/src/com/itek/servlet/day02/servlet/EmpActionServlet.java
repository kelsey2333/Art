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
import java.util.List;

@WebServlet(name = "EmpActionServlet" , urlPatterns = "*.do")
public class EmpActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        System.out.println(uri);
        EmpDao empDao = new EmpDaoImpl();
        switch (uri){
            case "/servletDay02/addEmp.do":
                req.setCharacterEncoding("utf-8");
                //接收浏览器端的参数
                String username = req.getParameter("username");
                String sal = req.getParameter("sal");
                String age = req.getParameter("age");
                System.out.println(sal);
                System.out.println(age);
                System.out.println(username);
                //将数据保存起来到数据库
                empDao.addEmp(new Emp(null,username,Double.parseDouble(sal),Integer.parseInt(age)));
                //返回设置数据的编码格式
                resp.setContentType("text/html;charset=utf-8");
                //返回客户端的数据给浏览器
                resp.sendRedirect("/servletDay02/listEmp.do");
                break;
            case "/servletDay02/delEmp.do":
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
                    resp.sendRedirect("/servletDay02/listEmp.do");
                }
                break;
            case "/servletDay02/listEmp.do":
                req.setCharacterEncoding("utf-8");

                /*
                 接收所有选择的数据以html中表格形式发送给浏览器
                 并且将实时的数据拼接上去
                 并且添加删除按钮
                 */
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
                            " <td><a href ='http://localhost:8080/servletDay02/delEmp.do?id="+ emp.getId() +"'><input type='button' value='删除'></td></a>"+
//                    " <td><a href ='http://localhost:8080/servletDay02/del/emp?id=" + str + "'><input type='button' value='删除'></a></td>" +
                            " </tr>");
                }

                sb.append("</tbody></table></body></html>");
                resp.setContentType("text/html;charset=utf-8");
                //将表中数据返回给客户端
                PrintWriter pw = resp.getWriter();
                pw.write(sb.toString());
                break;
        }
    }
}
