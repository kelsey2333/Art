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
 * @create: 2019-04-02 21:52
 **/
public class Emp extends Comparable<Emp> {
    private String name;
    private int age;
    private String gender;
    private int  salary;
    public Emp(String name,int age,String gender,double salary){
//        this.age
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int  compareTo(Emp emp){
        new Emp("Terry",25,"m",6000);
         new Emp("Allen",21,"f",4000);
         new Emp("Smith",23,"m",3000);
        return this.salary-emp.salary;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return age == emp.age &&
                Double.compare(emp.salary, salary) == 0 &&
                Objects.equals(name, emp.name) &&
                Objects.equals(gender, emp.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, salary);
    }
}