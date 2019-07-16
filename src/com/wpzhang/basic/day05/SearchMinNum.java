/**
 * @Author wpzhang
 * @Date 2019/3/11
 * @Description
 */
package com.wpzhang.basic.day05;

/**
 * @program: Wpzhang
 * @description: 最小值
 * @author: wpzhang
 * @create: 2019-03-11 14:14
 **/
public class SearchMinNum {
    public static void main(String[] args) {
        //创建一个长度是10的数组
        int[] arr = new int[10];
        //对数组中的元素进行随机赋值，取值范围是1~10
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
            System.out.print(arr[i] + " ");
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

        }
        System.out.println();
        System.out.println("最小值为：" + min);
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 1, arr.length);
        arr2[0] = min;
        System.out.print("新数组的数据为：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        //找出最小值重复的次数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                count++;
            }
        }
        System.out.println();
        System.out.println("最小值重复的次数为：" + count);
    }
}