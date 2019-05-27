/**
 * @Author wpzhang
 * @Date 2019/5/24
 * @Description
 */
package com.itek.servlet.day02.domain;

import java.io.Serializable;

/**
 * @program: servletDay02
 * @description: Emp实体类对象
 * @author: wpzhang
 * @create: 2019-05-24 12:57
 **/
public class Emp implements Serializable {
    public Emp(){}
    public Emp(Integer id,String name, double sal, Integer age) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.age = age;
    }
    private Integer id;
    private String name;
    private double sal;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", age=" + age +
                '}';
    }
}