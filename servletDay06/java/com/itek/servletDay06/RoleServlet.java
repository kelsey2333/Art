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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
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
        String uriStr = getUri(req.getRequestURI());
        RoleDao roleDao = new RoleDaoImpl();
        Role role = new Role();
        switch (uriStr){
            case "login":
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
            case "checkLogin":
                req.setCharacterEncoding("UTF-8");
                // 接收参数
                String loginName = req.getParameter("loginName");
                String pwd = req.getParameter("pwd");
                // TODO 验证码参数
                //获取验证码，getParameter("capchar")  capchar是单独的servelet

                // TODO 校验验证码(session)
                //获取session对象/
                /*
                1、获取正确验证码 getSession().getAttribute()
                2、将其转换成字符串
                3、之前的验证码和获取的验证码进行比较
                 */

                if ("admin".equals(loginName) && "admin".equals(pwd)) {
                    // 用户名和密码输入正确, 保存用户登录状态
                    HttpSession session = req.getSession();
                    // 使用Session存储用户的登录状态
                    // 如果该字段不存在,或者为false,表示未登录, 没有访问首页的权限
                    session.setAttribute("isLogin", true);
                    // session过期时间, 默认30分钟,
                    session.setMaxInactiveInterval(10);
                    // 重定向到首页
                    resp.sendRedirect(resp.encodeRedirectURL("/day06/index.role"));
                } else {
                    // 重定向到首页
                    resp.sendRedirect(resp.encodeRedirectURL("/day06/login.role"));
                }

            case "list":
                //执行查询语句调用selectAll()
                List<Role> allRoles = roleDao.selectAll();
                //绑定数据到request中setAttribute("属性名",属性值)
                req.setAttribute("allRoles",allRoles);
                //转发给jsp页面getRequestDispatcher(url)url定位到http://localhost:8080/servletDay06
                req.getRequestDispatcher("/WEB-INF/jsp/role_list.jsp").forward(req,resp);
                break;
            case "del":
                int id = Integer.parseInt(req.getParameter("id"));
                roleDao.delRole(id);
                //每次要重新全选数据进行显示而并不是直接跳转
                req.getRequestDispatcher("/list.role").forward(req,resp);
                break;
            case "add":
                //只进行显示
                req.getRequestDispatcher("/WEB-INF/jsp/role_add.jsp").forward(req,resp);
                break;
            case "addR":
                String roleName =  req.getParameter("roleName");
                //获取的是复选框设定的value值,即powerId
                String[] powerIdStr = req.getParameterValues("powerName");
                //将String型数组转换成Integer型数组
                Integer[] powerId = getPowerId(powerIdStr);
                //将用户输入的角色名称插入到t_role表中
                roleDao.addRoleName(roleName);
                //根据角色名称获取角色roleId
                int roleId = roleDao.receiveId(roleName);
                //根据roleId,powerId插入到t_role_power表中
                roleDao.addRole(roleId,powerId);
                req.getRequestDispatcher("/list.role").forward(req,resp);
                break;
            case "modi":
//                String modiRoleName = req.getParameter("roleName");
//                String modiPowerName = req.getParameter("powerName");
//                //绑定数据到request中setAttribute("属性名",属性值)
//                req.setAttribute("roleName",modiRoleName);
//                req.setAttribute("powerName",modiPowerName);

                //只进行显示
                req.getRequestDispatcher("/WEB-INF/jsp/role_modi.jsp").forward(req,resp);
                break;
            case "modiR":
                //获取修改后的角色名称
                String modiRoleName = req.getParameter("roleName");
                //获取修改后的权限id
                String[] modiPowerId = req.getParameterValues("powerName");
                Integer[] modiPowerNameId = getPowerId(modiPowerId);
                //根据角色名称获取角色roleId
                int roleId2 = roleDao.receiveId(modiRoleName);
                //根据roleId删除当前行
                roleDao.delRolePower(roleId2);
//                //将用户输入的角色名称插入到t_role表中
//                roleDao.addRoleName(modiRoleName);
                //根据roleId,powerId插入到t_role_power表中
                roleDao.addRole(roleId2,modiPowerNameId);
                req.getRequestDispatcher("/list.role").forward(req,resp);
                break;
            default:
                break;
        }
    }

    /**
     * @Param
     * @description 获取后缀
     * @date 2019/6/2 11:51
     * @return
     */

    private static String  getUri(String requestURI) {
       int start = requestURI.lastIndexOf("/")+1;
       int end = requestURI.lastIndexOf(".");
       return requestURI.substring(start,end);
    }

    private static Integer[] getPowerId(String[] powerIdStr){
        Integer[] powerId = new Integer[powerIdStr.length];
        for (int i = 0;i < powerIdStr.length;i++){
            powerId[i] = Integer.parseInt(powerIdStr[i]);
        }
        return powerId;
    }
}