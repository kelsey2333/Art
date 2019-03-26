/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 修剪前后
 * @author: wpzhang
 * @create: 2019-03-25 14:59
 **/
public class TrimTest {
    @Test
    public void testTrim(){
        String userName = " good man ";
        System.out.println(userName.trim());
        System.out.println(userName.trim().length());
    }
}