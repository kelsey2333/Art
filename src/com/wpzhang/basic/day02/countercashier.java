/**
 * @Author wpzhang
 * @Date 2019/3/9
 * @Description
 */
package com.wpzhang.basic.day02;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 柜台收银
 * @author: wpzhang
 * @create: 2019-03-09 08:44
 **/
public class countercashier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入单价：");
        double unitprice =scan.nextDouble();
        System.out.println("请输入数量：");
        int num =scan.nextInt();
        System.out.println("请输入金额：");
        double payment = scan.nextDouble();
        double totalprice = unitprice*num;
        System.out.println("应收金额为："+totalprice);
        double change = payment-totalprice;
        if (change<0){
            double change2=totalprice-payment;
            System.out.print("付款金额不够，请再付"+change2);
        }else {
            System.out.print("找零为：" + change);
        }
    }


}