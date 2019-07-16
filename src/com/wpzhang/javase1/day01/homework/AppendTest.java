/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01.homework;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 追加测试
 * @author: wpzhang
 * @create: 2019-03-25 15:41
 **/
public class AppendTest {
    @Test
    public void testAppend() {
        StringBuilder buf = new StringBuilder("Programming Language:");
        buf.append("I").append("am").append("very").append("lucky!");
        System.out.println(buf.toString());
    }
}