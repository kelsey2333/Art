/**
 * @Author wpzhang
 * @Date 2019/6/27
 * @Description
 */
package com.itek.spring.day04.mapping.controller;

import javafx.scene.input.MouseDragEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springDay04
 * @description:
 * @author: wpzhang
 * @create: 2019-06-27 18:43
 **/
@Controller
public class HelloController {
    Map<String,Object> modelObect = new HashMap<>();
    @RequestMapping("/hello.do")
    public ModelAndView hello(HttpServletRequest req,HttpServletResponse resp){
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        ModelAndView modelAndView = new ModelAndView();
        //获取数据并绑定，发送给指定jsp
        modelAndView.addObject("username",username);
        modelAndView.addObject("pwd",pwd);
        modelAndView.setViewName("Hello");
        return modelAndView;
    }

    @RequestMapping("/login.do")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        return modelAndView;
    }


}