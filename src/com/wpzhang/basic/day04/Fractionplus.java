/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package com.wpzhang.basic.day04;

import java.util.Scanner;

/**
 * @program: Wpzhang day04
 * @description: 分数相加
 * @author: wpzhang
 * @create: 2019-03-07 13:29
 **/
public class Fractionplus {
    public static void main(String[] args) {
        //接收用户输入的整数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = scan.nextInt();
        //以该整数做分母将分数进行相加
        double sum = 0;
        System.out.print(1);
        for (int i = 2; i <= a; i++) {
            System.out.print("+1/" + i);
        }
        for (int i = 1; i <= a; i++) {
          //  找到循环变量与循环执行体的关系
            sum += 1.0 / i;
        }
        System.out.print("=" + sum);
    }
}