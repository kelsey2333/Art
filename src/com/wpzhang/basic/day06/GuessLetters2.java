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
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < arr.length; i++) {
            //遍历数组，给数组元素随机赋值，赋level个值
            int index = (int) (Math.random() * (level + 1));
            arr[i]=letters[index];
        }//返回数组
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入等级：");
        int level = scan.nextInt();
        char[] arr = generate(level);
        System.out.println(arr);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("请输入"+level+"个字母");
        String input = scan.next();
        System.out.println(input);
        char[] arr2 = input.toCharArray();
        int count = 0;
        char[] chars=new char[arr.length];
        int index=0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr2[i]==arr[j]) {
                    chars=dropArrays(arr, arr[j]);
                    break;
                }
            }
            arr=chars;
        }
        System.out.println("您只答对了  " + (level-arr.length) + "个字母");

    }
    public static char[ ] dropArrays(char[] chars,char c) {
        char[] c1 = new char[chars.length - 1];
        int index = 0;
        for (char d : chars) {
            if (d == c) {
                continue;
            }
            c1[index] = (char) d;
            index++;
        }
        return c1;

    }
}