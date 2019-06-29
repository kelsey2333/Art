/**
 * @Author wpzhang
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.springSend;

import domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springDay05
 * @description: 提交数据到前端的方式
 * @author: wpzhang
 * @create: 2019-06-29 09:32
 **/
@Controller
public class CheckLogin {
    @RequestMapping("/login.do")
    public ModelAndView login(){
        return new ModelAndView("Login");
    }
    //第一种方式
//    @RequestMapping("/checkLogin.do")
//    public ModelAndView checkLogin(HttpServletRequest req){
//        String username = req.getParameter("username");
//        String password = req.getParameter("passqord");
//        req.setAttribute("username",username);
//        req.setAttribute("password",password);
//        return new ModelAndView("Index");
//    }
    //第二种方式:接受多个数据
//    @RequestMapping("/checkLogin.do")
//    public ModelAndView checkLogin(User user){
//        Map<String ,Object> params = new HashMap<>();
//        params.put("username",user.getUsername());
//        params.put("password",user.getPassword());
//        ModelAndView modelAndView = new ModelAndView("Index",params);
//        return modelAndView;
//    }
    //第三种方式：用内置的Model/ModelMap直接代替以上的Map*********（最简单常用）
    @RequestMapping("/checkLogin.do")
    public ModelAndView checkLogin(User user, Model model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        return new ModelAndView("Index");
    }
}