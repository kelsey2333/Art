/**
 * @Author wpzhang
 * @Date 2019/3/27
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description: 验证手机号码
 * @author: wpzhang
 * @create: 2019-03-27 22:22
 **/
public class CheckPhoneNum {
    public static boolean isMobileNum(String phoneNum) {
        // 移动号段正则表达式
        String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        //判断手机号码是否匹配
        if (phoneNum.length() != 11 && phoneNum.matches(pat1)) {
            return false;
        } else {
            return true;
        }
    }

    //检验号码是否合法
    public static void main(String[] args) {
        String pat1 = "18325658880";
        if (CheckPhoneNum.isMobileNum(pat1)) {
            System.out.println(pat1 + "是合法手机号码");
        } else {
            System.out.println(pat1 + "是非法手机号码");
        }
    }

}