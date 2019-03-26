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
 * @description: 获取子串的测试
 * @author: wpzhang
 * @create: 2019-03-25 14:53
 **/
public class SubstringTest {
    /**
     * @return void
     * @Param
     * @description 截取子字符串
     * @date 2019/3/26 6:27
     */

    @Test
    public void Substring() {
        String str = "http://www.oracle.com";
        //substring方法是前包后不包
        System.out.println(str.substring(11, 17));
        //返回字符串中从index开始到结尾的字符串
        System.out.println(str.substring(11));
        String str2 = "someapp/manager/emplist.action";
        System.out.println(str2.substring(16));
    }

    /**
     * @return void
     * @Param
     * @description 回文测试
     * @date 2019/3/26 6:28
     */

    public void tsetPlalindrome() {
        StringBuilder str = new StringBuilder("able was i ere i saw elba");
        boolean b1 = str.reverse() == str ? true : false;
        if (b1 == true) {
            System.out.println(str + " 为回文");
        } else {
            System.out.println(str + " 非回文");
        }
    }
}