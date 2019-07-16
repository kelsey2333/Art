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
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 数组转换为List
 * @author: wpzhang
 * @create: 2019-04-02 09:33
 **/
public class ArraysToList {
    @Test
    public void test(){
        List<String> l4 = new ArrayList<String>();
        l4.add("a");
        l4.add("b");
        l4.add("c");
        String[] str  = l4.toArray(new String[]{});
        List<String> l5 = new ArrayList<String>();
        System.out.println(l5.addAll(Arrays.asList(str)));
    }
}