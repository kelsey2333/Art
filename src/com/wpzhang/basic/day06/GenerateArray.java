/**
 * @Author wpzhang
 * @Date 2019/3/11
 * @Description
 */
package com.wpzhang.basic.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 封装数组
 * @author: wpzhang
 * @create: 2019-03-11 15:09
 **/
public class GenerateArray {
    public static int[] arr(int length, int range) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (range + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int length = scan.nextInt();
        System.out.println("请输入数组范围：");
        int range = scan.nextInt();
        int[] arr = arr(length, range);
        //调用数组方法时不用遍历
        System.out.println(Arrays.toString(arr));


    }
}