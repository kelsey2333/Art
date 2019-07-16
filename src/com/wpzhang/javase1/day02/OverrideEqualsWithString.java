/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: String重写equals方法
 * @author: wpzhang
 * @create: 2019-03-29 16:17
 **/
public class OverrideEqualsWithString {
    @Test
    public void test(){
        String s1 = new String ("abc");
        String s2 = new String ("abc");
        String s3 = new String("A");
        //true因为equals比较的是两个对象的地址（引用）
        System.out.println(s1.equals(s2));
        //false
        System.out.println(s1.equals(s3));
    }
}