/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: List转换成数组
 * @author: wpzhang
 * @create: 2019-04-02 09:26
 **/
public class ListToArray {
    @Test
    public void test() {
        List<String> l3 = new ArrayList<String>();
        l3.add("a");
        l3.add("b");
        l3.add("c");
        String[] str = l3.toArray(new String[]{});
        System.out.println(Arrays.toString(str));
    }
}