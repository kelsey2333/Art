/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 检索测试
 * @author: wpzhang
 * @create: 2019-03-25 14:42
 **/
public class IndexOfTest {
    @Test
    public void testIndexOf(){
        String str = "I can as long as I think I can";
        System.out.println(str.indexOf("can"));
        //String方法的重载
        System.out.println(str.indexOf("as",2));
        //str在字符中多次出现时，将返回最后一个出现的位置
        System.out.println(str.lastIndexOf("can"));
    }
}