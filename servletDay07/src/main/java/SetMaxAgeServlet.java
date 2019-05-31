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
import java.net.URLEncoder;

/**
 * @program: servletDay07
 * @description:
 * @author: wpzhang
 * @create: 2019-05-30 16:34
 **/
@WebServlet(name = "SetMaxAgeServlet",urlPatterns = "/time")
public class SetMaxAgeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //编码
        String encodeStr = URLEncoder.encode("呆子章","UTF-8");
        //设置关闭时间
        Cookie cookie = new Cookie("name",encodeStr);
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
    }
}