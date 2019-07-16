/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 包含
 * @author: wpzhang
 * @create: 2019-04-01 20:15
 **/
public class Contain {
    /*
    contain底层实现是通过equals方法：boolean equals(Object var1);即
     */
    @Test
    public void contain(){
        List<String> c = new ArrayList<String>();
        c.add("keep");
        c.add("happy");
        c.add("everyday");
        System.out.println(c);
        List<String> c1 = new ArrayList<String>();
        c1.add("happy");
        System.out.println(c1);
//        c1.add("");
        System.out.println(c.contains(c1));
    }
}