/**
 * @Author wpzhang
 * @Date 2019/3/25
 * @Description
 */
package com.wpzhang.javase1.day01.homework;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 删除测试
 * @author: wpzhang
 * @create: 2019-03-25 15:51
 **/
public class DeleteTest {
    /**
     * @return void
     * @Param
     * @description 删除测试
     * @date 2019/3/26 6:23
     */

    @Test
    public void testDelete() {
        StringBuilder buf = new StringBuilder("I am not a lucky girl !");
        System.out.println(buf.delete(5, 8).insert(8, "very ").append("And I love my parents").insert(24, "who is well taken care by her parents "));
    }

    @Test
    /**
     * @Param
     * @description 生成一个包含所有汉字的字符串
     * @date 2019/3/26 6:22
     * @return void
     */
//TODO 为什么不是几万个字
    public void testGenerateChineseCharecter() {
        //生成一个从"一"\u4e00到\u9fa5
        //包含所有汉字，所以要用循环
        int count = 0;
        for (char c = '\u4e00'; c <= '\u9fa5'; c++) {
            //提高效率用StringBuilder
            StringBuilder str2 = new StringBuilder();
            System.out.print(str2.append(c));
            count++;
            //每50个字母一行，所以要用计时器
            if (count % 50 == 0) {
                System.out.println();
            }
        }
    }
}