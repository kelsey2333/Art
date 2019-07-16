/**
 * @Author wpzhang
 * @Date 2019/3/28
 * @Description
 */
package com.wpzhang.javase1.day02;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: 正则表达式测试
 * @author: wpzhang
 * @create: 2019-03-28 21:47
 **/
public class RegEx3test {
    @Test
    public void testRegEx1() {
        String regex1 = "[a-z]";//a-z之间的任意一个字母
        String regex2 = "[^a-z]";//除了a-z之间的任意一个字母
        String regex3 = "[a-z&&[^bc]]";//a-z中除了bc的任意一个字母
        String regex4 = "\\d";//[0-9]之间任意整数
        String regex5 = "\\D";//非数字字符
        String regex6 = "\\s";//空白字符
        String regex7 = "S";
        String regex8 = "\\w";//[a-zA-Z_0-9]
        String regex9 = "\\W";//非单词字符
        System.out.println("a".matches(regex1));//true
        System.out.println("b".matches(regex2));//false
        System.out.println("f".matches(regex3));//true
        System.out.println("b".matches(regex4));//false
        System.out.println("1".matches(regex5));//false
        System.out.println(" ".matches(regex6));//true
        System.out.println(" ".matches(regex7));//false
        System.out.println("_".matches(regex8));//true
        System.out.println("_".matches(regex9));//false
    }

    /**
     * @return void
     * @Param
     * @description 检测正则表达式"*""+""?""/"
     * @date 2019/3/28 22:43
     */

    public void testRegEx2() {
        String regex1 = "[a-z]*";
        String regex2 = "\\w+\\.jar";
        String regex3 = "\\d?[a-z]*";
        System.out.println("abcde".matches(regex1));//*表示0到任意多个
        System.out.println("".matches(regex1));//true  0个也可以""表示0个
        System.out.println("lang.jar".matches(regex2));//\\w表示单词字符，lang是单词字符，所以返回true
        System.out.println(".jar".matches(regex2));//false
        System.out.println("1bc".matches(regex3));//true
        System.out.println("abc".matches(regex3));//\\d表示0个或一个整数所以返回true
    }
   /**
    * @Param
    * @description 测试正则表达式：”{n}.{m},{n,m}“
    * @date 2019/3/29 6:15
    * @return  void
    */
    @Test
    public void testRegEx3(){
        String regex1 = "\\w{5}";
        System.out.println("abcef".matches(regex1));//true
        System.out.println("abefg".matches(regex1));//true
        String regex2 = "[a-zA-Z_0-9]{5,8}";
        System.out.println("12345".matches(regex2));//true
        System.out.println("123456".matches(regex2));//true

    }
}