/**
 * @Author wpzhang
 * @Date 2019/3/4
 * @Description
 */
package com.wpzhang.basic.day01;

import java.util.Scanner;

public class Homeworkmodify2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入单价：" );
        double price = scan.nextDouble();
        System.out.println("请输入数量：" );
        int num = scan.nextInt();
        System.out.println("请输入付款金额：");
        double payment = scan.nextDouble();
        double  totalPrice,change;
        totalPrice = price *num;
        if(totalPrice >= 500 ){
            totalPrice = totalPrice * 0.8;
        }change = payment - totalPrice;
        System.out.println("应收金额：" + totalPrice);
        System.out.println("找零：" + change);
    }
}