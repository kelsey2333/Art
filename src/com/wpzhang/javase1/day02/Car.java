/**
 * @Author wpzhang
 * @Date 2019/3/28
 * @Description
 */
package com.wpzhang.javase1.day02;

/**
 * @program: Wpzhang
 * @description: 重写toString
 * @author: wpzhang
 * @create: 2019-03-28 06:14
 **/
public class Car {
    //成员变量
    private String carNo;
    private String carName;
    private String color;
    private double price;

    //有参构造函数
    Car(String carNo,String carName,String color,double price){
        this.carNo=carNo;
        this.carName=carName;
        this.color=color;
        this.price=price;
    }

    //get set方法
    public String getCarNo(){
        return carNo;
    }

    public void setCarNo(String carNo){
        this.carNo=carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //重写toString();
    public String toString(){
        return "这个汽车名叫 "+carName+",型号是 "+carNo+",汽车颜色 "+color+",价格 "+price;
    }

    public static void main(String[] args){
        //创建一个Car的对象
        Car myCar=new Car("苏A 4995","长安汽车","灰蓝色",70000.00);   //类名开头字母大写
        System.out.println(myCar.toString());
    }
}