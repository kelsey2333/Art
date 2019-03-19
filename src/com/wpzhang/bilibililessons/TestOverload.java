/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.bilibililessons;

/**
 * @program: Wpzhang
 * @description: 测试方法重载
 * @author: wpzhang
 * @create: 2019-03-17 16:56
 **/
public class TestOverload {
    //定义一个求和方法
    public static int sum(int a, int b) {//此处不加static便报错？？:因为静态的都从属于类
        //非静态的普通方法从属于对象，所以静态的方法不可以调用非静态的，而非静态的可以调用静态的
        //同理，this可以用在非静态方法中，不可以用在静态方法中，因为this是属于对象的
        int sum = a + b;
        return sum;
    }

    //方法名相同，参数个数不同 ---构成重载
    public static int sum(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }

    //方法名相同，参数顺序不同 ---构成重载
//    public int sum(int b,int a);会和第一个方法产生歧义，此种“方法名相同，参数顺序不同”不构成重载
    //方法名相同，参数类型不同（签字名不同-方法名加参数类型）---构成重载
    public static double sum(double a, int b) {
        double sum = a + b;
        return sum;
    }

    //方法名相同，参数顺序不同 --- 构成重载  方法签名不能相同
    public static double sum(int a, double b) {
        double sum = a + b;
        return sum;
    }

    //main函数程序执行入口
    public static void main(String[] args) {
        System.out.println(sum(1, 2));
        System.out.println(sum(3, 55, 3));
        System.out.println(sum(3.0, 5));
        System.out.println(sum(3, 5.0));
    }


}