/**
 * @Author wpzhang
 * @Date 2019/3/28
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-28 06:38
 **/
public class Equals {
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Emp) {
            Emp emp = (Emp) obj;
            return emp.name == "kelsey" && emp.age == 23;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Equals newEquals = new Equals();
        System.out.println(newEquals.equals("kelsey"));
    }
}