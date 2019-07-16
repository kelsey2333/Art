/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day03.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @program: Wpzhang
 * @description: 用LocalDate打印日历
 * @author: wpzhang
 * @create: 2019-04-01 10:45
 **/
public class PrintCalendar {
    public static void main(String[] args) {
        //实例化一个Date对象
        LocalDate date = LocalDate.now();
        //得到月份并用整型变量month接收
        int month = date.getMonthValue();
        //得到日份并用整型变量today接收
        int today = date.getDayOfMonth();//今天是2号

        //从date类中返回一个DayOfWeek
        DayOfWeek weekday = date.getDayOfWeek();
        //调用weekday的getValue方法得到今天是星期几
        int value = weekday.getValue();
        date.minusDays(today + 1);
        //打印星期目录
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i =1; i < value;i++){
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.printf("*");
            } else {
                System.out.printf(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println("下一个月");
        }
    }
}