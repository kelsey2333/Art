/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.bilibililessons;

/**
 * @program: Wpzhang
 * @description: 测试静态修饰符
 * @author: wpzhang
 * @create: 2019-03-17 21:34
 **/
public class TestStatic {
    //静态修饰成员变量
    public static int age;
    public static String name;
    //静态修饰方法
    public  void myName(){
        System.out.println("My name is "+name );
    }
    //静态修饰类
    public  static class human{
        public static void main(String[] arg){
            System.out.println("I am"+age +"years old");
        }
    }

}