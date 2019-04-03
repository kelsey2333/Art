/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @program: Wpzhang
 * @description: 排序
 * @author: wpzhang
 * @create: 2019-04-02 09:54
 **/
public class List {
    @Test
    public void test() {
        java.util.List<Integer> l = new ArrayList<Integer>();
        //将数集合打印输出
        // 使用有参数构造生成Random对象，不管执行多少次，每次得到的结果都相同
        Random r = new Random(1);
        //随机产生0-100之间的数
        for (int i = 0; i < 10; i++) {
            //random.nextInt(n)：随机生成一个正整数，整数范围[0,n)
            l.add(r.nextInt(100));
        }
        System.out.println(l);
        //排序
        Collections.sort(l);
        System.out.println(l);
    }
}