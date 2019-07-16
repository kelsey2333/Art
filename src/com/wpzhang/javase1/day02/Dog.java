/**
 * @Author wpzhang
 * @Date 2019/3/31
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-31 21:34
 **/
public class Dog<override> {

        int age;
        int height;
        String color;


    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }

    @Test
        public   void test() {
            Dog a = new Dog();
            a.age = 1;
            a.height = 10;
            a.color = "white";
            System.out.println(a.toString());

    }
}