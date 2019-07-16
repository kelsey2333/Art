/**
 * @Author wpzhang
 * @Date 2019/3/31
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description:为什么要重写toString
 * @author: wpzhang
 * @create: 2019-03-31 21:49
 **/
public class Address {
    /**
     * @Param
     * @description 为什么要重写toString方法
     * @date 2019/3/31 21:40
     * @return  void
     */
    private  String name;
    public Address(String name){
        this.name = name;
    }
//    public String toString(){
//        return name;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Object[] arr = new Object[1];
        arr[0] = new Address("中国 大理");
        for (int i = 0; i < arr.length;i++){
            System.out.println("显示结果："+arr[i]);
        }
    }
}