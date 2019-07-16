/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-29 14:35
 **/
public class replaceALL {
    @Test
    public void testReplceAll() {
        String str = "I will niver give up I beg!";
        str = str.replaceAll(" ","!");
        System.out.println(str);
    }
}