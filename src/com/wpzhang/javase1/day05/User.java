/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day05;

import java.util.Objects;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-02 20:02
 **/
public class User {
    private int age;
    public User(int age){this.age = age;}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}