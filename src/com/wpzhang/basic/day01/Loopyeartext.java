/**
 * @Author wpzhang
 * @Date 2019/3/5
 * @Description
 */
package com.wpzhang.basic.day01;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 闰年测试
 * @author: wpzhang
 * @create: 2019-03-05 23:07
 **/
public class Loopyeartext {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scan.nextInt();
        boolean b1 = year%4 ==0 && year%100 !=0;
        boolean b2 = year%400==0;
        boolean b3 = b1 || b2;
        String msg = ( b3 ?"是闰年":"非闰年");
        System.out.println("该年份为：" +msg);

    }
}