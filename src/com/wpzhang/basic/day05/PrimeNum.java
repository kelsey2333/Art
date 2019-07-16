/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package com.wpzhang.basic.day05;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-07 20:23
 **/
public class PrimeNum {
    public static void main(String[] args) {
        //先判断一个数是不是质数
        Scanner scan = new Scanner(System.in);
        System.out.println("请您输入一个范围" + "2~");
        int maxval = scan.nextInt();
        int count = 0;
        for (int num = 2; num <= maxval; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= num -1 ; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
                if (isPrime){
                System.out.print(num+" ");
                    count++;
            }
            if (count%10==0){
                System.out.println();
        }
        }
    }
}
