/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: Wpzhang
 * @description: 拆分测试
 * @author: wpzhang
 * @create: 2019-03-29 14:08
 **/
public class SplitTest {
    @Test
    public void testSplit(){
        //按空格拆分
        String introduceMe = "I like doing sports!";
        //拆分方式以逗号和0到任意多个空格拆分
       //  System.out.println(Arrays.toString(introduceMe.split(",\\s*")));
        // 等价于
        String[] strArr = introduceMe.split("[\\s]");
        System.out.println(Arrays.toString(strArr));
        String calulate = "100+20=120";
        String[] strArr2 = calulate.split("[(\\+)=]");
        System.out.println(Arrays.toString(strArr2));
    }
}