/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description: 重写toString方法
 * @author: wpzhang
 * @create: 2019-03-29 15:04
 **/
public class OverrideToString {
        String name;
        int age;
        int salary;
        String gender;
    public OverrideToString(String name, int age , int salary, String gender){
       this.name = name;
       this.age = age;
       this.gender = gender;
       this.salary = salary;
    }
    public void print(){ }

    //定义String类型.所以需要返回值
    public String toString(){
       return getClass().getName()+"[name ="+name+",age = "+age+",salary="+salary+",gender="+gender+"]";
    }

    public static void main(String[] args) {
        OverrideToString print = new OverrideToString("zhangwuping",23,4000,"女");
        System.out.println(print);
    }
}