/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 遍历字符序列
 * @author: wpzhang
 * @create: 2019-03-25 15:04
 **/
public class CharAtTest {
    @Test
    public void testCharAt(){
        String name = "What's up!";
        for (int i = 0;i < name.length();i++){
            char c = name.charAt(i);
            System.out.print(c + " ");
//            System.out.print(c);
        }
    }
}