/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description: 测试静态修饰符
 * @author: wpzhang
 * @create: 2019-03-17 21:34
 **/
public class TestStatic {
    //静态修饰成员变量
    public static int age;
    public String name;

    //静态修饰方法  属于类的方法
    public static void print() {
        //静态的方法可以调用静态的成员变量
        System.out.println(age);
        //但是不可以调用非静态的
//        System.out.println(name);
    }

    //非静态的可以访问静态的方法，非静态的属于对象，对象的方法可以调用静态的方法
    public void print2() {
        System.out.println("My name is " + name);
    }

    //静态的不可以调用非静态的方法，main 方法是静态的，这里是？？
    public static void main(String[] args) {
        TestStatic t = new TestStatic();
        t.print();
        t.print2();
        //此处是对象调用非静态的方法,当没有new对象时 ，要用类名调用非静态方法
    }

    //静态修饰类
    public static class human {
        public static void main(String[] arg) {
            System.out.println("I am" + age + "years old");
        }
    }
}