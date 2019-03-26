/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 检测字符串以什么开头
 * @author: wpzhang
 * @create: 2019-03-25 15:10
 **/
public class StartWithTest {
    @Test
    public void testStartWithAndEndWith(){
        String str = "Thinking java with art emotion";
        System.out.println(str.startsWith("Think"));
        System.out.println(str.endsWith("emotion"));
        System.out.println(str.endsWith("n"));
    }
}