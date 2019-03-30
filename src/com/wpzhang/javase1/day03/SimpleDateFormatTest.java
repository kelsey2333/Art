/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day03;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {
    /**
     * @program: Wpzhang
     * @description:日期格式化:将Date转换成String
     * @author: wpzhang
     * @create: 2019-03-29 19:31
     **/
    @Test
    public void testFormat() {
        SimpleDateFormat sdf = new
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String datestr = sdf.format(date);
        System.out.println(datestr);
    }
    /**
     * @Param
     * @description 解析：将String转换成Date
     * @date 2019/3/30 9:48
     * @return
     */

    @Test
    public void testParse() throws Exception {
        String str = "01-05";
        //首先创建SimpleDateFormat类型对象
        //然后进行转换
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd");
        Date date = sdf2.parse(str);
        System.out.println(date);
    }
}