/**
 * @Author wpzhang
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.springReceive;

import domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springDay05
 * @description: 接收前端提交的数据
 * @author: wpzhang
 * @create: 2019-06-29 08:38
 **/
@Controller
public class CheckLoginReceive {
    @RequestMapping("/login.do")
    public ModelAndView login(){
        return new ModelAndView("Login");
    }
    //第一种接收提交过来的数据
//    @RequestMapping("/checkLogin.do")
//   public ModelAndView checkLogin(HttpServletRequest req, HttpServletResponse resp){
//       String username =  req.getParameter("username");
//       String password = req.getParameter("password");
//       //绑定接收到的数据发送出去
//        ModelAndView modelAndView = new ModelAndView("Index");
//        modelAndView.addObject("username",username);
//        modelAndView.addObject("password",password);
//        return modelAndView;
//    }
//    第二种接收数据的方式 *********************(数据少时用),并且可以配合加类的方法
    @RequestMapping("/checkLogin.do")
    public ModelAndView checkLogin(User user,String password){
        //绑定数据将数据发送出去
        ModelAndView modelAndView = new ModelAndView("Index");
        modelAndView.addObject("username",user.getUsername());
        modelAndView.addObject("password",password);
        return modelAndView;
    }
    //第四种接收数据的方式注入到参数中 当传入的参数与前端传过来的参数不一致时
//    @RequestMapping("/checkLogin.do")
//    public ModelAndView checkLogin(@RequestParam("password")String pwd,@RequestParam("username")String name){
//        ModelAndView modelAndView = new ModelAndView("Index");
//        modelAndView.addObject("password",pwd);
//        modelAndView.addObject("username",name);
//        return modelAndView;
//    }
    //第三种接收数据的方式 ***************(数据多时用)
//    @RequestMapping("/checkLogin.do")
//    public ModelAndView checkLogin(User user){
//        ModelAndView modelAndView = new ModelAndView("Index");
//        modelAndView.addObject("username",user.getUsername());
//        modelAndView.addObject("password",user.getPassword());
//        return modelAndView;
//    }




}