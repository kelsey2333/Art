/**
 * @Author wpzhang
 * @Date 2019/4/3
 * @Description
 */
package com.wpzhang.javase1.day05;

import com.wpzhang.oop.day02.O;

/**
 * @program: Wpzhang
 * @description: 室友工资大测评
 * @author: wpzhang
 * @create: 2019-04-03 13:51
 **/
public class Roomate implements Comparable<Roomate>{
    private String name;
    private String gender;
    private String weight;
    private int Salary;
    private String age;
   public Roomate(String name, String gender, String weight, int Salary, String age){
       this.age = age;
       this.gender = gender;
       this.name = name;
       this.Salary = Salary;
       this.weight = weight;

   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;

    }

    @Override
    public String toString() {
        return "Roomate[" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", weight='" + weight + '\'' +
                ", Salary=" + Salary +
                ", age='" + age + '\'' +
                ']';
    }

    public int compareTo(Roomate roomate){
        new Roomate("若玙","小仙女","都暴瘦",10000,"永远18岁");
        new Roomate("张平","小仙女","都暴瘦",10001,"永远18岁");
        new Roomate("Me","小仙女","都暴瘦",10002,"永远18岁");
        new Roomate("海燕","小仙女","都暴瘦",10003,"永远18岁");
        new Roomate("徐云","小仙女","都暴瘦",10004,"永远18岁");
        new Roomate("何静","小仙女","都暴瘦",10005,"永远18岁");
       return this.Salary -roomate.Salary;
    }
}