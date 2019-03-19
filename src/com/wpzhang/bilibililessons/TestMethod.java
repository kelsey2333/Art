/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.bilibililessons;

/**
 * @program: Wpzhang
 * @description: 测试方法的使用
 * @author: wpzhang
 * @create: 2019-03-17 13:19
 **/
public class TestMethod {
    //创建打印输出方法（无参）
    void print() {
        System.out.println("I will be better!");
        System.out.println("I will be better!");
        System.out.println("I will be better!");
    }

    //创建有参方法
    int sum(int a, int b) {
        int sum = a + b;
        return sum;//return作用：1、结束程序运行  2、返回值
    }

    //通常在main方法中通过对象调用方法
    public static void main(String[] args) {
        TestMethod p = new TestMethod();//创建一个对象（new一个对象）
        p.print();//只有对象可以调用方法
        int sum2 = p.sum(2, 5) + 100;
        System.out.println(sum2);
    }

}