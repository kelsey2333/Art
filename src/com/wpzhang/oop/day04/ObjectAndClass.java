/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description: 测试对象和类的关系
 * @author: wpzhang
 * @create: 2019-03-17 14:07
 **/
public class ObjectAndClass {
    //属性field（成员变量id,name，age）
    int id;
    String name;
    int age;

    //方法：study
    void print1() {
        System.out.println("I am studying!");
    }

    //方法：玩游戏
    void print2() {
        System.out.println("I am playing games!");
    }

    //    ObjectAndClass(){};
    //程序执行入口必须要有
    public static void main(String[] args) {
        //创建对象；关于对象名为什么和类名相同的问题    因为系统会自动生成一个无参的方法 见上
        ObjectAndClass doing = new ObjectAndClass();
        doing.print1();
        doing.print2();
    }
    //调用print方法
}