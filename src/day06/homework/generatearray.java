/**
 * @Author wpzhang
 * @Date 2019/3/8
 * @Description
 */
package day06.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 封装数组
 * @author: wpzhang
 * @create: 2019-03-08 21:51
 **/
public class generatearray {
    public static int[] arr(int length, int range) {
        int[] arr = new int[length];
        //随机产生指定长度的数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (range + 1));
        }//返回数组
        return arr;
    }

    public static void main(String[] args) {
        //调用数组函数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数组的长度：");

        int length = scan.nextInt();
        System.out.println("请输入数组的范围：0~");
        int range = scan.nextInt();
        int[] arr = arr(length, range);
        System.out.println(Arrays.toString(arr));

    }


}