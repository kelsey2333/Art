/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day04;

import com.wpzhang.javase1.day02.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @program: Wpzhang
 * @description: 测试类
 * @author: wpzhang
 * @create: 2019-04-01 18:29
 **/
public class Test {
    @org.junit.Test
    public void test(){
        Cell2 c =new Cell2(3,5);
        System.out.println(c);
    }
    @org.junit.Test
    public void testSizeAndClearAndEmpty(){
        Collection<String> c = new ArrayList<String>();
        System.out.println("isEmpty:" + c.isEmpty());
        c.add("terry");
        c.add("allen");
        c.add("jerry");
        c.add("smith");
        System.out.println("isEmpty: " + c.isEmpty()+" ,size: " + c.size());
        c.clear();
        System.out.println("isEmpty: " + c.isEmpty()+" ,size: " + c.size());
    }
    @org.junit.Test
    public void testAddAllAndContainsAll(){
        Collection<String> c1 = new ArrayList<String>();
        c1.add("terry");
        c1.add("allen");
        System.out.println(c1);
        Collection<String> c2 = new HashSet<String>();
        c2.addAll(c1);
        System.out.println(c2);
        Collection<String> c3 = new HashSet<String>();
        c3.add("terry");
        System.out.println(c1.containsAll(c3));

    }
}