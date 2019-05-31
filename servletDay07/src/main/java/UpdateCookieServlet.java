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
 * @create: 2019-05-30 15:35
 **/
@WebServlet(name = "UpdateCookieServlet",urlPatterns ="/update")
public class UpdateCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       Cookie[] cookies =  req.getCookies();
       if (cookies != null){
           for (Cookie c:cookies){
              String name = c.getName();
               System.out.println(name+"===========");
              if ("username".equals(name)){
                  c.setValue("wpzhang");
                  resp.addCookie(c);
              }
           }
       }
    }
}
