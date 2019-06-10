/**
 * @Author wpzhang
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servletDay06;

import dao.RoleDao;
import dao.RoleDaoImpl;
import domain.Role;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
            case "index":
                // 先对用户进行登录校验, 判断用户是否已经登录
                HttpSession session = req.getSession();
                // 获取登录验证字段
                if (session.getAttribute("isLogin")!= null &&
                        (Boolean)session.getAttribute("isLogin") == true) {
                    // 说明用户一已经登过了,可以访问首页
                    req.getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                            .forward(req, resp);
                } else {
                    // 使用重定向
                    resp.sendRedirect(resp.encodeRedirectURL("/servletDay06/login.role"));
                }
                break;
            case "login":
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
                break;
            case "captche":
                // 1. 创建画板
                BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
                // 2. 创建画笔
                Graphics g = image.getGraphics();
                // 3. 设置画笔颜色
                Random r = new Random();
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                // 4. 绘制背景颜色
                g.fillRect(0, 0, 80, 20);
                // 5. 绘制随机生成字符串
                String randomStr = generateRandomString(5);
                HttpSession CapSession = req.getSession();
                CapSession.setAttribute("cap",randomStr);
                // 6. 设置字体
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                g.setFont(new Font("微软雅黑", Font.BOLD, 18));
                g.drawString(randomStr, 5, 15);
                // 7. 绘制干扰线
                for (int i = 1; i <= 8; i++) {
                    g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                    g.drawLine(r.nextInt(80), r.nextInt(20), r.nextInt(80), r.nextInt(20));
                }
                // 8. 将图片输出到客户端
                resp.setContentType("image/jpeg");
                OutputStream os = resp.getOutputStream();
                ImageIO.write(image, "jpeg", os);
                os.close();
                break;
            case "checkLogin":
                req.setCharacterEncoding("UTF-8");
                // 接收参数
                String loginName = req.getParameter("loginName");
                String pwd = req.getParameter("pwd");
                //获取验证码
                String inputCap = req.getParameter("captche");
                //获取session对象/
                String standardCap = (String)req.getSession().getAttribute("cap");
                System.out.println("standardCap:" + standardCap);
                if (standardCap.equals(inputCap)||standardCap.toLowerCase().equals(inputCap)){
                    if (isLoginName(loginName) && isPassword(pwd)) {
                        System.out.println("用户名：" + loginName);
                        System.out.println("密码：" + pwd);
                        // 用户名和密码输入正确, 保存用户登录状态
                        session = req.getSession();
                        // 使用Session存储用户的登录状态
                        // 如果该字段不存在,或者为false,表示未登录, 没有访问首页的权限
                        session.setAttribute("isLogin", true);
                        // session过期时间, 默认30分钟,
                        session.setMaxInactiveInterval(10);
                        // 重定向到首页
                        resp.sendRedirect(resp.encodeRedirectURL("/servletDay06/index.role"));
                        break;
                    } else {
                        // 重定向到登录页面
                        System.out.println("重定向到登录页面");
                        resp.sendRedirect(resp.encodeRedirectURL("/servletDay06/login.role"));
                        break;
                    }
                }else{
                    resp.sendRedirect(resp.encodeRedirectURL("/servletDay06/login.role"));
                    break;
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
                //根据roleId,powerId插入到t_role_power表中
                roleDao.addRole(roleId2,modiPowerNameId);
                req.getRequestDispatcher("/list.role").forward(req,resp);
                break;
            default:
                break;
        }
    }
    private static boolean isLoginName(String loginName){
        String loginNameStr = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        if (loginName.matches(loginNameStr)){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isPassword(String Password){
        String PasswordStr = "^[0-9a-zA-Z_!.]{8,16}$";
        if (Password.matches(PasswordStr)){
            return true;
        }else{
            return false;
        }
    }

    private String generateRandomString(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < length;i++){
            char ch = str.charAt(random.nextInt(36));
            sb.append(ch);
        }
        return sb.toString();
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