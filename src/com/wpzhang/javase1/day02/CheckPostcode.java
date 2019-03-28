/**
 * @Author wpzhang
 * @Date 2019/3/27
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description:验证邮编
 * @author: wpzhang
 * @create: 2019-03-27 22:06
 **/
public class CheckPostcode {
    public static boolean checkPostcode(String postcode) {
        String format = "\\p{Digit}{6}";
            // 验证邮编的正则表达式
        if (postcode.matches(format)) {
            // 邮编合法，返回true
            return true;
        } else {
            // 邮编不合法，返回false
            return false;

        }
    }
    public static void main(String[] args) {
        String postcode = "130000";
        if (CheckPostcode.checkPostcode(postcode)) {
            // 验证邮编
            System.out.println(postcode + "是合法的邮编。");
        } else {
            System.out.println(postcode + "不是合法的邮编。");
        }
    }
}