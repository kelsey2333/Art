/**
 * @Author wpzhang
 * @Date 2019/4/3
 * @Description
 */
package com.wpzhang.javase1.day05;

import org.junit.Test;

import java.util.*;
import java.util.List;

/**
 * @program: Wpzhang
 * @description:室友大评测
 * @author: wpzhang
 * @create: 2019-04-03 13:59
 **/
public class ComparatorTest {
    /**
     * @return
     * @Param
     * @description sort(list)
     * @date 2019/4/3 14:23
     */

    @Test
    public void testComparator() {
        List<Roomate> r = new ArrayList<Roomate>();
        r.add(new Roomate("若玙", "小仙女", "都暴瘦", 10004, "永远18岁"));
        r.add(new Roomate("张平", "小仙女", "都暴瘦", 10001, "永远18岁"));
        r.add(new Roomate("Me", "小仙女", "都暴瘦", 10007, "永远18岁"));
        r.add(new Roomate("海燕", "小仙女", "都暴瘦", 10003, "永远18岁"));
        r.add(new Roomate("徐云", "小仙女", "都暴瘦", 10002, "永远18岁"));
        r.add(new Roomate("何静", "小仙女", "都暴瘦", 10008, "永远18岁"));
        System.out.println(r);
        Collections.sort(r);
        System.out.println(r);
    }
/**
 * @Param
 * @description sort(list, comparator)
 * @date 2019/4/3 14:36
 * @return void
 */
@Test
     public void testRoomate2(){
         List<Roomate> r = new ArrayList<Roomate>();
         r.add(new Roomate("若玙", "小仙女", "都暴瘦", 10004, "永远18岁"));
         r.add(new Roomate("张平", "小仙女", "都暴瘦", 10001, "永远18岁"));
         r.add(new Roomate("Me", "小仙女", "都暴瘦", 10007, "永远18岁"));
         r.add(new Roomate("海燕", "小仙女", "都暴瘦", 10003, "永远18岁"));
         r.add(new Roomate("徐云", "小仙女", "都暴瘦", 10002, "永远18岁"));
         r.add(new Roomate("何静", "小仙女", "都暴瘦", 10008, "永远18岁"));
         System.out.println(r);
         Collections.sort(r, new Comparator<Roomate>(){
             @Override
             public int compare(Roomate roomate1, Roomate roomate2) {
                 return roomate1.getSalary() - roomate2.getSalary();
             }
         });
         System.out.println(r);

         Collections.sort(r, new Comparator<Roomate>() {
             @Override
             public int compare(Roomate roomate1, Roomate roomate2) {
                 return roomate2.getSalary() - roomate1.getSalary();
             }
         });
         System.out.println(r);
     }

}