/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 测试电子邮件号码
 * @author: wpzhang
 * @create: 2019-03-29 13:54
 **/
public class EmailTest {
    @Test
    public void email(){
        //eg:2390547685@qq.com
        //eg:18325658880@163.com
        //开头可以匹配1到数字字母下划线和中划线
        //接着匹配@，然后匹配数字字母下划线，然后匹配点，最后匹配2-3个字母
        String emailRegEx = "^[a-zA-Z0-9-_]+@([a-zA-Z0-9-]+\\.)[a-zA-Z]{2,3}$";
        System.out.println("18325658880@163.com".matches(emailRegEx));
    }
}