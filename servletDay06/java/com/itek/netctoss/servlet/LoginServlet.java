/**
 * @Author wpzhang
 * @Date 2019/6/10
 * @Description
 */
package com.itek.netctoss.servlet;

import com.itek.netctoss.service.MenuService;
import com.itek.netctoss.service.impl.MenuServiceImpl;
import dao.AdminDao;
import dao.Impl.AdminDaoImpl;
import domain.Menu;

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
import java.util.List;
import java.util.Random;

/**
 * @program: netctoss
 * @description:
 * @author: wpzhang
 * @create: 2019-06-10 16:04
 **/
@WebServlet(name = "LoginServlet",urlPatterns = "*.role")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI =  req.getRequestURI();
        String uriStr = getUri(requestURI);
        switch (uriStr){
            case "login":
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
                break;
            case "captcha":
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
                String loginName = req.getParameter("loginName");
                String pwd = req.getParameter("pwd");
                String inputCaptcha = req.getParameter("captcha");
                String standardCaptcha = (String)req.getSession().getAttribute("cap");
                HttpSession session = req.getSession();
                if (isLoginName(loginName) && isPwd(pwd)){
                    if (standardCaptcha.equals(inputCaptcha)||standardCaptcha.toLowerCase().equals(inputCaptcha)){
                        //登入的状态保存到session中
                        session.setAttribute("isLogin",true);
                        session.setAttribute("loginName",loginName);
                        //重定向到首页
                        resp.sendRedirect("/netctoss/index.role");
                    }else{
                        //重定向到登录页面并输出：验证码错误
                        resp.sendRedirect("/netctoss/login.role?msg=验证码错误");
                    }
                }else {
                    resp.sendRedirect("/netctoss/login.role?msg=用户名或密码错误");
                }
                break;
            case"index":
                //获取到保存在session中的loginName
               String name= (String)req.getSession().getAttribute("loginName");
                //通过name查询到用户id
                AdminDao adminDao = new AdminDaoImpl();
                int id = adminDao.selectUser(name).getId();
                //通过id查询用户所能访问的菜单列表
                MenuService menuService = new MenuServiceImpl();
                List<Menu> menus = menuService.SelectMenusByUserId(id);
                HttpSession session1 = req.getSession();
                //将menu集合塞到session中
                session1.setAttribute("menus",menus);
                req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
                break;
        }
    }

    private String generateRandomString(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0;i < length; i++){
            char ch = str.charAt(r.nextInt(36));
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * @Param
     * @description 检验密码
     * @date 2019/6/10 18:36
     * @return
     */
    private boolean isPwd(String pwd) {
        String PasswordStr = "^[0-9a-zA-Z_!.]{8,16}$";
        if (pwd.matches(PasswordStr)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Param
     * @description 用户名校验
     * @date 2019/6/10 18:34
     * @return
     */

    private boolean isLoginName(String loginName) {
        String loginNameStr = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        if (loginName.matches(loginNameStr)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Param
     * @description 获取后缀
     * @date 2019/6/10 16:12
     * @return
     */

    private static String  getUri(String requestURI) {
        int start = requestURI.lastIndexOf("/")+1;
        int end = requestURI.lastIndexOf(".");
        return requestURI.substring(start,end);
    }
}