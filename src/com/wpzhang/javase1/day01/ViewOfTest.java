/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 其他类型转换成字符串
 * @author: wpzhang
 * @create: 2019-03-25 15:21
 **/
public class ViewOfTest {
    @Test
    public void testValueOf(){
        double pi = 3.1415926;
        String str = String.valueOf(pi);
        System.out.println(str);
        int value = 123;
        String str2 = String.valueOf(value);
        System.out.println(str2);
        boolean flag = true;
        String str3 = String.valueOf(flag);
        System.out.println(str3);
        char[] charARR = {'a','b','c','d','e','f','g'};
        String str4 = String.valueOf(charARR,2,5);
        System.out.println(str4);
    }
}