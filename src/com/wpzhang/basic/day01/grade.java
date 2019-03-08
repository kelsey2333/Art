/**
 * @Author wpzhang
 * @Date 2019/3/5
 * @Description
 */
package com.wpzhang.basic.day01;

import java.util.Scanner;

/**
 * @program: java12
 * @description: grade
 * @author: wpzhang
 * @create: 2019-03-05 11:
 **/
public class grade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入成绩：" );
        double grade = scan.nextDouble();
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 60) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }
}