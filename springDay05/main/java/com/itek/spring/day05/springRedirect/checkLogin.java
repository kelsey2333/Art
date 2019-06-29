/**
 * @Author wpzhang
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.springRedirect;

import domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springDay05
 * @description:
 * @author: wpzhang
 * @create: 2019-06-29 10:05
 **/
@Controller
public class checkLogin {
    @RequestMapping("/login.do")
    public ModelAndView login(){
        return new ModelAndView("Login");
    }
    @RequestMapping("/checkLogin.do")
    //重定向地址写全并且定位到项目根目录
    public String checkLogin(User user){
        if (user.getUsername().equals("wpzhang")&&user.getPassword().equals("666")){
            return "redirect:/login.do?msg="+user.getUsername()+"：您的用户名和密码正确！";
        }else{
            return "redirect:/login.do?msg="+user.getUsername()+":您的用户名或密码错误！";
        }
    }
}