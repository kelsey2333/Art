package servlet; /**
 * @Author wpzhang
 * @Date 2019/6/13
 * @Description
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ajax
 * @description:
 * @author: wpzhang
 * @create: 2019-06-13 15:23
 **/
@WebServlet(name = "CheckLoginNameServlet",urlPatterns = "*.login")
public class CheckLoginNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String uriStr = getUri(uri);
        String loginName = req.getParameter("loginName");
        switch (uriStr){
            case "check":
                if (loginName.equals("wpZhang")){
                    resp.getWriter().write("1");
                }else {
                    resp.getWriter().write("0");
                }
                break;
        }

         resp.setContentType("text/html;charset = utf-8");
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