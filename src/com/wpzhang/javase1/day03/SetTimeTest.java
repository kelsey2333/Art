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
 * @description: setget方法
 * @author: wpzhang
 * @create: 2019-03-29 19:04
 **/
public class SetTimeTest {
    @Test
    public void testSetTime(){
    //输出当天的日期时间
        Date date = new Date();
        //输出1997至今经历的时间
        System.out.println(date);
        long time  = date.getTime();
        System.out.println(time );
        //增加一天的毫秒数
        time += 24*60*60*1000;
        //输出增加一天的毫秒数之后的日期时间
        date.setTime(time);
        System.out.println(date);
    }
    @Test
    public void testGetTime(){
        Date date = new Date();
        //输出当前时间日期
        System.out.println(date);
        //输出当前毫秒数
        long time = date.getTime();
        System.out.println(time);
    }
}