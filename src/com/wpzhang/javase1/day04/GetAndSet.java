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
 * @description:
 * @author: wpzhang
 * @create: 2019-04-02 08:40
 **/
public class GetAndSet {
    @Test
    public void testGetAndSet(){
        List<String> l = new ArrayList<String>();
        l.add("I");
        l.add("am");
        l.add("very");
        l.add("lucky");
        l.add("!");
        for (int i = 0;i <l.size();i++){
            System.out.print(l.get(i).concat(" "));
        }
        l.set(3,"a");
        l.set(4,"girl");
        System.out.println(l);//I am a very lucky girl !
        l.set(3,l.set(2,l.get(3)));
    }
}