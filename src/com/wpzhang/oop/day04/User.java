/**
 * @Author wpzhang
 * @Date 2019/3/15
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-15 18:59
 **/
public class User {
    //puublic:所有地方都能用，姓名(public修饰的成员变量姓名)
    public String name;
    //protected:子类和同一个包中的类，id（家人能看的）
    protected String id;
    //什么都不加：同一个包中的类，年龄
    String age;
    //private：当前类中使用，只有自己能看到，体重
    private double weight;

    //构造test方法
    public void test() {
    //方法体中就是打印输出name,id,age,weight
        System.out.println(name);
        System.out.println(id);
        System.out.println(age);
        System.out.println(weight);
    }
}
