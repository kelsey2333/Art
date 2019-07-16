/**
 * @Author wpzhang
 * @Date 2019/5/30
 * @Description
 */
package com.wpzhang.javase1.Map;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-05-30 06:40
 **/
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> sets = new HashSet<>();
        sets.add("h");
        sets.add("e");
        sets.add("l");
        sets.add("l");//不可重复
        sets.add("0");

        //方法一：迭代遍历
        for (Iterator<String> iterator = sets.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        //输出结果：
        /*
        0
        e
        h
        l
         */
        //可以看出Set集合是不可重复（添加重复操作不会报错）且无序的

        //方法二：foreach循环（没有普通for循环方法）
        for (String value:sets) {
            System.out.println(value);
        }
    }
}
