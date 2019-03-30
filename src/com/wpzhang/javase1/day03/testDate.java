/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day03;

import org.junit.Test;

import java.util.Date;

/**
 * @program: Wpzhang
 * @description: Date类封装日期及时间信息
 * @author: wpzhang
 * @create: 2019-03-29 16:31
 **/
public class testDate {
    @Test
    public void testGetDate() {
        //实例化时期，系统当前的日期及时间信息
        Date date = new Date();
        System.out.println(date);
        //1970年1月1日零点至此刻的毫秒
        long time = date.getTime();
        System.out.println(time);
    }
}