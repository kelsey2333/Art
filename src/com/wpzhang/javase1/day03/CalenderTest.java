/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day03;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.CancellationException;


public class CalenderTest {
    /**
     * @program: Wpzhang
     * @description: 日历测试
     * @author: wpzhang
     * @create: 2019-03-29 19:50
     **/
//日历是一个final修饰的类，不能实例化，所以要用getinstanceof方法，获得此类型的通用对象
    @Test
    public void testGetInstance() {
        //实例化Calendar
        Calendar c = Calendar.getInstance();
        //获取当前创建的子类类型名称
        System.out.println(c.getClass().getName());
        //获取当前系统保存的时间
        System.out.println(c.getTime());
        //创建格林尼兹日历对象
        //并且将制定的时间输入
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2018, Calendar.AUGUST, 8);
        //打印输出制定创建的时间（以一种简单易懂的方式）
        System.out.println(gregorianCalendar.getTime());
    }

    /**
     * @return void
     * @Param
     * @description setTime
     * @date 2019/3/29 20:18
     */
    @Test
    public void setTest() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, Calendar.AUGUST);
        c.set(Calendar.DATE, 8);
        System.out.println(c.getTime());
        c.set(Calendar.DATE, 9);
        System.out.println(c.getTime());
    }
@Test
    public void testGet() {
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.YEAR,2019);
        c2.set(Calendar.MONTH, Calendar.JANUARY);
        c2.set(Calendar.DATE,05);
        int dayOfWeek = c2.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);//周六
    }
    /**
     * @Param
     * @description 看看五一是周几放假
     * @date 2019/3/29 22:03
     * @return  void
     */
    @Test
    public void testLabor(){
        Calendar c3 = Calendar.getInstance();
        c3.set(Calendar.YEAR,2019);
        c3.set(Calendar.MONTH,Calendar.MAY);
        c3.set(Calendar.DATE,1);

        int dayOfWeek = c3.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);//周三
        System.out.println(c3.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c3.getTime()));

    }
}