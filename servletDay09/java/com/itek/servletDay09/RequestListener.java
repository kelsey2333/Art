/**
 * @Author wpzhang
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servletDay09;


import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: servletDAY09
 * @description:
 * @author: wpzhang
 * @create: 2019-06-03 13:04
 **/
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }



    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
           HttpServletRequest request =  (HttpServletRequest)servletRequestEvent.getServletRequest();
           String uri = request.getRequestURI();
           String color = request.getParameter("color");
           String method = request.getMethod();

//        listenerDao.addInfo(uri,"color",method,,color)
        System.out.println(color);
    }
}