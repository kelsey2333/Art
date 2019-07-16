/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 插入和删除
 * @author: wpzhang
 * @create: 2019-04-02 09:00
 **/
public class InsertAndDelete {
    @Test
    public void test() {
        //[0,1,2,3,4,5,6,7,8,9]
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            l1.add(i);
        }
        System.out.println(l1);
        //[3,4,5,6,7]
        List<Integer> sub = l1.subList(3, 7);
        //操作后重新打印
        System.out.println(sub);
        for (int i = 0; i < sub.size(); i++) {
            sub.set(i, sub.get(i) * 10);
        }
        System.out.println(sub);
        System.out.println(l1);
        //删除连续元素
        l1.subList(3, 7).clear();
        System.out.println(l1);
    }
}