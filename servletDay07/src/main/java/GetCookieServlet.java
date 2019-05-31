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
 * @create: 2019-05-30 15:14
 **/
@WebServlet(name = "GetCookieServlet", urlPatterns = "/get/Cookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Cookie[] cookies =  req.getCookies();
        //如果对象是空的将错误信息返回给浏览器
        if (cookies == null){
            resp.getWriter().write("Cookie不存在");
            return;
        }else{
            for (Cookie c1:cookies){
                System.out.println( c1.getName()+":"+c1.getValue());
            }
        }
    }
}