/**
 * @Author wpzhang
 * @Date 2019/5/27
 * @Description
 */
package com.itek.servlet.day04;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay04
 * @description: 初始化Servlet
 * @author: wpzhang
 * @create: 2019-05-27 14:20
 **/
public class initParamServlet extends HttpServlet {
    //重写父类中的init方法

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //通过ServletConfig获取
        String companyName =  config.getInitParameter("companyName");
        System.out.println(companyName + "================");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("destroy==============");
    }
}