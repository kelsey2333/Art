/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-01 10:21
 **/
public class PersonTest {

    @Test
    public void test() {
        Person p1 = new Person("kelsey");
        Person p2 = new Person("kelsey  ");
        Person p3 = new Person(null);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
            /*返回true
             list中含有生成的person对象，结果为true
             */
        System.out.println("是否包含kelsey: " + list.contains(p1));
        //返回false？？
        System.out.println("是否包含kelsey: " + list.contains(p2));
        //由于对称性原则
        System.out.println("是否包含kelsey: " + list.contains(p3));
    }

    @Test
    public void test2() {
        Employee e1 = new Employee("kelsey", 12);
        Employee e2 = new Employee("kelsey", 123);
        Person p1 = new Person("kelsey");
        //用到equals方法时就直接去看equals方法中的方法体即可
        System.out.println(p1.equals(e1));
        System.out.println(p1.equals(e2));
        System.out.println(e1.equals(e2));
    }
}