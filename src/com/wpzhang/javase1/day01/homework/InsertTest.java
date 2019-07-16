/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01.homework;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 插入测试
 * @author: wpzhang
 * @create: 2019-03-25 15:48
 **/
public class InsertTest {
    @Test
    public void testInsert(){
        StringBuilder buf = new StringBuilder("I am lucky!");
        System.out.println(buf.insert(5,"very "));
    }
}