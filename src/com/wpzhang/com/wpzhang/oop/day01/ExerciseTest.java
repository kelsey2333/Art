/**
 * @Author wpzhang
 * @Date 2019/3/12
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day01;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-12 15:36
 **/
public class ExerciseTest {
    public static void main(String[] args) {
        //创建一个对象
        ExerciseTest result = new ExerciseTest();
        //调用方法add
        System.out.println(result.add("4", "5"));
    }

    public int add(int a, int b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }
}
