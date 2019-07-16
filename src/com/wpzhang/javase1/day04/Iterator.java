/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day04;


import java.util.Collection;
import java.util.HashSet;

/**
 * @program: Wpzhang
 * @description: 迭代器
 * @author: wpzhang
 * @create: 2019-04-02 05:48
 **/
public class Iterator {
    public void testHasNextAndNext(){
        /*这里的HashSet是接口Collection的实现类，
        因为里面有很多被实现的方法所以不是接口而是实现类
        既然是类就可以被实例化
         */

        Collection<String> c =new  HashSet<String>();
        c.add("java");
        c.add("cpp");
        c.add("php");
        c.add("objective-c");
        c.add("c#");
        System.out.println(c);
        java.util.Iterator<String> iterator = c.iterator();
    }

}