/**
 * @Author wpzhang
 * @Date 2019/3/27
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 验证身份证号码是否合法
 * @author: wpzhang
 * @create: 2019-03-27 19:32
 **/
public class CheckIDNum {
    public static boolean checkID(String IDNum) {
        String idNum = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        if (IDNum == null && IDNum.matches(idNum)) {
            return false;
        } else {
            return true;
        }
    }

    //验证省份证号码是否合法
    public static void main(String[] args) {
        String idNum = " 340823199701057024";
        if (checkID(idNum)) {
            System.out.println("该身份证号码合法");
        } else {
            System.out.println("该身份证号码非法");
        }
    }
}
