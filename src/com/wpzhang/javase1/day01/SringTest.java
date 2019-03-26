/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 测试String常量池
 * @author: wpzhang
 * @create: 2019-03-25 14:11
 **/
public class SringTest {
    @Test
    public void testConstantPool(){
        String str1 = "Hello";
        //不会在堆中创建新的String对象，而是使用常量池中已有的"Hello"
        String str2 = "Hello";
        System.out.println(str1 == str2);
        //使用new关键字会在堆中创建新的String对象
        String str3 = new String();
        System.out.println(str1 == str3);
    }
}