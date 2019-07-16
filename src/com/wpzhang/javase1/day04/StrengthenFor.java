/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @program: Wpzhang
 * @description: 增强for循环
 * @author: wpzhang
 * @create: 2019-04-02 08:23
 **/
public class StrengthenFor {
    @Test
    public void test() {
        Collection<String> c2 = new ArrayList<String>();
        c2.add("I");
        c2.add("just");
        c2.add("want");
        c2.add("to");
        c2.add("do");
        c2.add("sports");
        for (String str:c2){
            System.out.print(str+" ");
        }
    }
}