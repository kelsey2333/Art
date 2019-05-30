/**
 * @Author wpzhang
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servletDay06;

import dao.RoleDao;
import dao.RoleDaoImpl;
import domain.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: servletDay06
 * @description:
 * @author: wpzhang
 * @create: 2019-05-29 15:28
 **/
@WebServlet(name = "RoleServlet",urlPatterns = "*.role")
public class RoleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //解析请求路径
       String uriStr =  getUri(req.getRequestURI());
        switch (uriStr){
            case "list":
                //执行查询语句调用selectAll()
                RoleDao roleDao = new RoleDaoImpl();
                List<Role> allRoles = roleDao.selectAll();
                System.out.println("所有的roleName:"+allRoles);
                //绑定数据到request中setAttribute("属性名",属性值)
                req.setAttribute("allRoles",allRoles);
                //转发给jsp页面getRequestDispatcher(url)url定位到http://localhost:8080/servletDay06
                req.getRequestDispatcher("/jsp/role_list.jsp").forward(req,resp);
                break;
            default:
                break;
        }
    }

    private static String  getUri(String requestURI) {
       int start = requestURI.lastIndexOf("/")+1;
       int end = requestURI.lastIndexOf(".");
       return requestURI.substring(start,end);
    }
}