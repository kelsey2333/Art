/**
 * @Author wpzhang
 * @Date 2019/3/11
 * @Description
 */
package com.wpzhang.oop.day01.pptitems;

/**
 * @program: Wpzhang
 * @description: 打印员工信息
 * @author: wpzhang
 * @create: 2019-03-11 19:41
 **/
public class PrintEmpInfo {
    String name ;
    int age;
    char gender;
    double sal;
    public void  printInfo(){
        //定义 printInfo的成员变量
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("性别："+gender);
        System.out.println("薪水："+sal);
    }
    public static void main(String[] args) {
        PrintEmpInfo Homie = new PrintEmpInfo();
        //对成员变量进行赋值
        Homie.name ="呆子章";
        Homie.age = 22;
        Homie.gender = '女';
        Homie.sal = 4000;
        Homie.printInfo();

    }
}