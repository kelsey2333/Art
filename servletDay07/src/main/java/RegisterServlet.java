/**
 * @Author wpzhang
 * @Date 2019/5/30
 * @Description
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay07
 * @description:
 * @author: wpzhang
 * @create: 2019-05-30 14:46
 **/
@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取提交的数据可以是在地址栏敲回车，也可以是在html提交username location
       String username =  req.getParameter("username");
       String location = req.getParameter("location");
        System.out.println(username);
        System.out.println(location);
        //创建Cookie对象
        Cookie c1 = new Cookie("username",username);
        Cookie c2 = new Cookie("location",location);
        //设置setCookie消息头并返回给浏览器，此时浏览器会保存下来
        c1.setMaxAge(30);
        resp.addCookie(c1);
        resp.addCookie(c2);
    }
}