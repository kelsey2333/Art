/**
 * @Author wpzhang
 * @Date 2019/3/8
 * @Description
 */
package com.wpzhang.basic.day04;

import java.util.Arrays;

/**
 * @program: Wpzhang
 * @description: 找到最小值并放在第一位
 * @author: wpzhang
 * @create: 2019-03-08 14:43
 **/
public class Checkminnum {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 1, arr.length);
        arr2[0] = min;
        for (int index = 0; index < arr2.length; index++) {
            System.out.print(arr2[index]+" ");
        }
    }
}
