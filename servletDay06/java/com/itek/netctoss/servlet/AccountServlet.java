/**
 * @Author wpzhang
 * @Date 2019/6/12
 * @Description
 */
package com.itek.netctoss.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: netctoss
 * @description: 账务账号业务处理器
 * @author: wpzhang
 * @create: 2019-06-12 06:21
 **/
@WebServlet(name = "AccountServlet",urlPatterns = "*.acc")
public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 拦截地址进行截取
        String requestURI =  req.getRequestURI();
        String uriStr = getUri(requestURI);
        switch (uriStr){
            case "account":
                //查询账号列表页
                req.getRequestDispatcher("/WEB-INF/jsp/accountList.jsp").forward(req,resp);
                break;
            case "update":
                //修改账号列表页
                break;
            case "add":
                //增加账号
                break;
            case "del":
                //删除账号
                break;
        }




    }
    /**
     * @Param
     * @description 获取后缀
     * @date 2019/6/12 6:44
     * @return
     */
    private String getUri(String requestURI) {
        int start = requestURI.lastIndexOf("/")+1;
        int end = requestURI.lastIndexOf(".");
        return requestURI.substring(start,end);
    }
}