/**
 * @Author wpzhang
 * @Date 2019/3/8
 * @Description
 */
package com.wpzhang.basic.day06;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * @program: Wpzhang
 * @description: 封装数组
 * @author: wpzhang
 * @create: 2019-03-08 21:51
 **/
public class GuessLetters2 {
    public static char[] generate(int level) {
        char[] arr = new char[level];
        char[] letters= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
        'P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < arr.length; i++) {
            //将letters里的level个任意字母赋给arr
            int index = (int) (Math.random() * (level + 1));
        }//返回数组arr
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入游戏等级：");
        int level = scan.nextInt();
        char[] arr = generate(level);
        System.out.println(Arrays.toString(generate(level)));
        //接受用户输入的字母
        Scanner scan2 = new Scanner(System.in);
        System.out.println("请输入字母：");
        String input = scan.next();
        //字符转换为字符数组
        char[] arr2 = input.toCharArray();
        System.out.println(Arrays.toString(arr2));
        //比较用户输入字母与指定字母
        int count=0;
        for (int i =0;i<arr.length;i++){
            for (int j =0 ; j<arr2.length;j++) {
                if (arr[i] == arr2[j]) {
                    count++;
                }
            }
        }System.out.println("你只答对了"+count+"个字母，继续加油！");

    }


}