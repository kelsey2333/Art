/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-01 11:47
 **/
public class AddAll {
    @Test
    public void testAddAllAndContainsAll(){
        Collection<String> c1 = new ArrayList<String>();
        c1.add("java");
        c1.add("php");
        c1.add("cpp");
        c1.add("c#");
        c1.add("objective-c");
        System.out.println(c1);
        Collection<String> c2 = new HashSet<String>();
        c2.addAll(c1);
        System.out.println(c2);
        Collection<String> c3 = new ArrayList<String>();
        c3.add("java");
        c3.add("cpp");
        System.out.println(c1.containsAll(c3));
    }
}