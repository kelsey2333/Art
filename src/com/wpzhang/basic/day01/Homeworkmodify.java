/**
 * @Author wpzhang
 * @Date 2019/3/5
 * @Description
 */
package com.wpzhang.basic.day01;

/**
 * @program: Wpzhang
 * @description: test
 * @author: wpzhang
 * @create: 2019-03-05 20:20
 **/
public class Homeworkmodify {
    public static void main(String[] args) {

        //1、
        int length = 10;
        System.out.println(length);//length变量没有声明。
        //2、
        int size = 20;//不能由&符号组成变量。等号左右最好有空格。
        System.out.println(size);//不能由&符号组成变量名。
        //3、
        int age = 30;//没有对变量进行初始化。
        System.out.println(age);
        //4、
        int count = 30;
        count = 60;
        System .out.println(count);//运行结果为60，30是对count的初始化，60则是对count的赋值运算
        //5、
        double balance;
        balance = 218.50;//balance 为整数型,不能将浮点数赋值给balance。
        //6、
        int i = 128;
        i = 1000000008;
        System.out.println(i);/*整型范围是-2*10^31~2*10^31-1
        10000000008值太大，应该改为10000000008。*/
        //7、
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2);

        //输出的结果为：1551700409940
        //8、
        double width = 6.0;
        double lenght = 4.9;
        System.out.println(width-lenght);/*输出结果为1.09999999999。2进制表示10进制会有一些舍入误差，对于一些要求精
        确运算的场合会导致代码的缺陷。*/
        //9、
        char ascii = 98;
        System.out.println(ascii);/*输出结果为b。变量中实际存储
        的即该整数值，但表示的是该整数值所对应的Unicode字符*/
        //10、
        byte b1 = 10;
        byte b2 = 20;
        int b3 = b1 + b2;//b1+b2结果是整型，整型不能自动转换成字节型。
        //11、
        int a = 1,b = 10;
        int c1 = a++;//a先赋值给c1,在进行自增。
        int c2 = ++b;//b先自增，再赋值给c2。
        System.out.println("a="+a+",b="+b+",c1="+c1+",c2="+c2);
        //12、
        int t = 100,j = 200;
        boolean t1 = (t > j) &&(t++ > 100);/*100<200,且&&符号前者false则整个运算试false
        并不会计算后面表达式，因此t值并没有改变*/
        System.out.println(t1);
        System.out.println(t);
    }
}