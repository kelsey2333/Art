/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package com.wpzhang.basic.day05.pptday05items;

import java.util.Arrays;

/**
 * @program: Wpzhang day04
 * @description: 数组完整复制
 * @author: wpzhang
 * @create: 2019-03-07 15:56
 **/
public class Arraycopy {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 33, 4};
        int[] arr2 = Arrays.copyOf(arr1, 3);//截取arr1中的3个元素组成新的数组
        for (int index = 0; index < arr2.length; index++) {
            System.out.print(arr2[index] + " ");
        }
    }
}