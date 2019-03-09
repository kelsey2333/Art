/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package com.wpzhang.basic.day05.pptday05items;

/**
 * @program: Wpzhang day04
 * @description: 数组复制
 * @author: wpzhang
 * @create: 2019-03-07 15:35
 **/
public class Partofarraycopy {
    public static void main(String[] args) {
        int[] arr ={3, 2, 1, 5,4,3,2,1,};
        int[] arr2 = new int[9];//创建一个新的数组
        System.arraycopy(arr,1,arr2,3,2);//复制原数组中的部分内容
        for (int index = 0;index<arr2.length;index++){
            System.out.print(arr2[index]);
        }//再输出复制的数组
    }
}