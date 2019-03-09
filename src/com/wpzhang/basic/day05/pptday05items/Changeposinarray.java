/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package com.wpzhang.basic.day05.pptday05items;

/**
 * @program: Wpzhang day04
 * @description: 交换数组中的shuzi
 * @author: wpzhang
 * @create: 2019-03-07 15:03
 **/
public class Changeposinarray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int temp = arr[2];
        arr[2] = arr[1];
        arr[1] = temp;//交换第二个第三个元素位置
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index]);
        }//遍历数组元素
    }
}