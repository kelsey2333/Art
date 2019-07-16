/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01.homework;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 大小写转换
 * @author: wpzhang
 * @create: 2019-03-25 15:16
 **/
public class ToUpperTest {
    @Test
    public void testToUpper(){
        String str = "我喜欢running";
        System.out.println(str.toUpperCase());
    }
    @Test
    public void testToLower(){
        String str = "我喜欢RUNNING";
        System.out.println(str.toLowerCase());
    }
}