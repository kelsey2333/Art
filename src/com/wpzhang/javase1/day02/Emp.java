/**
 * @Author wpzhang
 * @Date 2019/3/28
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description: 重写Emp类
 * @author: wpzhang
 * @create: 2019-03-28 05:54
 **/
public class Emp {

    String name;
    int age;
    String gender;
    double salary;

    /**
     * 打印信息的方法
     */
    public Emp(String name,int age,String  gender,int salary) {
       this.name = name;
       this.age = age;
       this.gender = gender;
       this.salary =salary;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String  getGender() {
        return gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setGender(String  gender) {
        this.gender = gender;
    }

    public String toString() {
        return "The employer's name is " + name + ",and I'm " + age + "years old." + "I'm a " + gender + ",my salary is " + salary;
    }

    public static void main(String[] args) {
        Emp newEmp = new Emp("kelsey",23,"girl",4000);
        System.out.println(newEmp.toString());
    }
}

