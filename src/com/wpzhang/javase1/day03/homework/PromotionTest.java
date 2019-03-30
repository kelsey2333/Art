/**
 * @Author wpzhang
 * @Date 2019/3/30
 * @Description
 */
package com.wpzhang.javase1.day03.homework;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 保质期的测试
 * @author: wpzhang
 * @create: 2019-03-30 10:10
 **/
public class PromotionTest {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        //获取产品生产日期
        System.out.println("请输入产品生产日期（yyyy-MM-dd）:");
         String strdate = scan.next();
         //解析生产日期
        SimpleDateFormat productDate = new  SimpleDateFormat("yyyy-MM-dd");
        //解析生产日期并用date1接收这个日期
        Date date1 = productDate.parse(strdate);
        //获取产品保质期
        System.out.println("请输入产品保质期：");
        int qualityDays = scan.nextInt();
        //将日历的时间改成生产日期
        Calendar calendar = Calendar.getInstance();
        //当运行到这一步时，Calendar的年月日就已经改变为生产日期的年月日
        //计算保质期时间
        calendar.add(Calendar.DATE,qualityDays);
//        System.out.println( calendar.add(Calendar.DATE,qualityDays));不能直接输出是因为add方法没有返回值？？
        calendar.add(Calendar.DATE,-14);
        //区别setTime()和set()的区别
        calendar.set(Calendar.DAY_OF_WEEK,4);//该DATE这一周的第4天：周三
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }
}