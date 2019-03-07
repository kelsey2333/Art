/**
 * @Author wpzhang
 * @Date 2019/3/6
 * @Description
 */
package com.wpzhang.day04;

/**
 * @program: Wpzhang day04
 * @description: 运行结果
 * @author: wpzhang
 * @create: 2019-03-06 19:40
 **/
public class runningresult {
    public static void main(String[] args) {
        long sum = 0;
        for (long i = 9; i <= 999999999; i = i * 10 + i) {
            sum += i;
            System.out.println();
        }
        System.out.println("9+99+999+...+99999999999" + "=" + sum);
    }
}