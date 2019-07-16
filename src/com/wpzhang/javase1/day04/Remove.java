/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day04;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: Wpzhang
 * @description:Iterator中的remove方法
 * @author: wpzhang
 * @create: 2019-04-02 06:26
 **/
public class Remove {
    @Test
    public void testRomove() {
        Collection<String> coll = new HashSet<String>();
        coll.add("java");
        coll.add("cpp");
        coll.add("php");
        coll.add("objective-c");
        coll.add("c#");
        coll.add("cpp");
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){
            String str = it.next();
            if (str.equalsIgnoreCase("cpp")) {
                it.remove();
            }
        }
        System.out.println(coll);
    }
}