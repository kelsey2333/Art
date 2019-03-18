/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-17 21:06
 **/
public class Human {
    public String name;
    protected String id;
    private double weight;
    String gender;

    public static void main(String[] args) {
        Human h = new Human();
        h.name= "章吴萍";
        h.id = "340823.....";
        h.weight = 200;//此时在同一个类里可以访问private修饰的成员变量
        h.nAndWeight();
    }
    private void nAndWeight(){
        System.out.println(name+"为"+weight+"斤");
    }
}