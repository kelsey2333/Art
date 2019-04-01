/**
 * @Author wpzhang
 * @Date 2019/3/30
 * @Description
 */
package com.wpzhang.javase1.day03.localdatetime;

import org.junit.Test;
import sun.awt.geom.AreaOp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: Wpzhang
 * @description: LocalDate类与Calendar类的区别
 * @author: wpzhang
 * @create: 2019-03-30 14:36
 **/
/*
1、LocalDate类时final修饰的    Calendar时abstract修饰的
 */


/**
 * @Param
 * @description 取当前日期
 * @date 2019/3/31 11:54
 * @return  void
 */

public class LocalDateTest {
    @Test
    public void testLocalDateTime1() {
        //取当前日期
        java.time.LocalDate today = java.time.LocalDate.now();//2019-3-30
        System.out.println(today);
    }

    @Test
    public void testCalendar1() {
        //取当前日期
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
    }

    /**
     * @return
     * @Param
     * @description 根据年月日取日期
     * @date 2019/3/30 15:20
     */

    @Test
    public void testLocalDateTime2() {
        //根据年月日取日期
        java.time.LocalDate christmas = java.time.LocalDate.of(2019, 12, 25);
        System.out.println(christmas);
    }

    @Test
    public void testCalendar2() {
        //根据年月日取日期
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 25);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
    }

    /**
     * @return void
     * @Param 根据字符串取
     * @date 2019/3/30 15:30
     */

    @Test
    public void testLocalDateTime3() {
        java.time.LocalDate endOfFeb = java.time.LocalDate.parse("2019-02-28");
        System.out.println(endOfFeb);
    }

    @Test
    public void testCalendar3() throws ParseException {
        String str = "2019-2-28";
        //先格式化再进行解析
        SimpleDateFormat formatStr = new SimpleDateFormat("yyyy-MM-dd");
        //输出解析后的日期
        System.out.println(formatStr.parse(str));
        //再格式化解析后的日期进行输出
        System.out.println(formatStr.format(formatStr.parse(str)));
    }

    /**
     * @return void
     * @Param
     * @description 取本月的第一天
     * @date 2019/3/30 15:48
     */
    @Test
    public void testLocalDateTime4() {
        //取这个月的第一天
        java.time.LocalDate firstDayOfThisMonth = java.time.LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth);
    }

    @Test
    public void testCalenbdar4() {
        //取这个月的第一天
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//无返回值不可以直接收
        System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(calendar.getTime()));//有返回值可以直接接收
    }

    /**
     * @return void
     * @Param
     * @description 取这个月的最后一天
     * @date 2019/3/30 16:25
     */
    @Test
    public void testLocalDateTime5() {
        java.time.LocalDate lastDayaOfThisMonth = java.time.LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayaOfThisMonth);
    }

    @Test
    public void testCalendar5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }

    /**
     * @return void
     * @Param
     * @description 取下一天
     * @date 2019/3/30 16:36
     */
    @Test
    public void testLocalDateTime6() {
        java.time.LocalDate nextDay = java.time.LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
        //plusDays()方法自动转换成4月1号
        System.out.println(nextDay);
    }

    @Test
    public void testCalendar6() {
        //用add方法
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        //add方法自动加1转换成4月1号
        calendar.add(Calendar.DATE, 1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }

    /**
     * @return void
     * @Param TODO 用Calendar 很麻烦
     * @description 取2019年1月第一个周一
     * @date 2019/3/31 10:04
     */
    @Test
    public void testLocalDateTime() {
        java.time.LocalDate firsMondayOf2019 = java.time.LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firsMondayOf2019);
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        //第一个月的第一周的第一天（周日）的日期
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 0);
    /*
    首先判断第一个月的第一周的第一天该日期年的分量是否为2019，若是则输出下一天
    若不是则将日的分量加1然后是否是2019年
    若不是则将日的分量加7然后判断是否是2019年
     */
        if (Calendar.YEAR == 2019) {
            calendar.add(Calendar.DATE, 1);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        } else {
            calendar.add(Calendar.DATE, 1);
            if (Calendar.YEAR == 2019) {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            } else {
                calendar.add(Calendar.DATE, 7);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

}