/**
 * @Author wpzhang
 * @Date 2019/3/31
 * @Description
 */
package com.wpzhang.javase1.day03.localdatetime;

import com.wpzhang.oop.day02.L;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * @program: Wpzhang
 * @description: LocalTime测试
 * @author: wpzhang
 * @create: 2019-03-31 11:52
 **/
public class LocalTimeTest {
    /**
     * @return void
     * @Param
     * @description 获取当前时间(非日期) ，含毫秒值
     * @date 2019/3/31 12:03
     */
    @Test
    public void testLocalTime1() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }
    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd-ss").format(calendar.getTime()));

    }
    /**
     * @Param
     * @description 通过get方法获取时间的时分秒
     * @date 2019/3/31 15:54
     * @return  void
     */
    @Test
    public void get(){
        LocalTime get = LocalTime.parse("16:17:23");
        System.out.println("Hour = "+get.getHour());
        System.out.println("Minute = "+get.getMinute());
        System.out.println("Second = "+get.getSecond());
    }


    /**
     * @return void
     * @Param
     * @description 获取当前时间  去掉毫秒值或者时分秒
     * @date 2019/3/31 12:09
     */
    @Test
    public void testLocalTime2() {
        //nano:毫，纳的意思
        LocalTime now1 = LocalTime.now().withNano(0);
        System.out.println(now1);
        LocalTime now2 = LocalTime.now().withHour(0);
        System.out.println(now2);
        LocalTime now3 = LocalTime.now().withMinute(0);
        System.out.println(now3);
        LocalTime now4 = LocalTime.now().withSecond(0);
        System.out.println(now4);
    }
    /**
     * @Param
     * @description 构造时间
     * @date 2019/3/31 15:39
     * @return void
     */
@Test
    public  void testLocalTime3(){
        LocalTime constructTime = LocalTime.parse("13:34:12");
        System.out.println(constructTime);
        LocalTime constructTime2 = LocalTime.of(14,23,34);
        System.out.println(constructTime2);
    }
}