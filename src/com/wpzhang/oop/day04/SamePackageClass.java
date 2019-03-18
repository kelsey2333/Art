/**
 * @Author wpzhang
 * @Date 2019/3/15
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description: 同一个包的类
 * @author: wpzhang
 * @create: 2019-03-15 18:44
 **/
public class SamePackageClass {
    //创建一个test普通方法
    public void test() {
        //创建一个wpzhang对象
        User wpzhang = new User();
        //打印姓名
        System.out.println(wpzhang.name);
        //打印id
        System.out.println(wpzhang.id);
        //打印年龄
        System.out.println(wpzhang.age);
        //打印体重:无法打印，因为weight成员变量是private修饰的成员变量
//        System.out.println(wpzhang.weight);
    }
    String name;
    String id;
    double age;
    public SamePackageClass(String name,String id,double age){
        this.name =name;
        this.id = id;
        this.age = age;
    }
public  SamePackageClass(){
        name = "wpzhng";

}
    public static void main(String[] args) {

    }
}