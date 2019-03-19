/**
 * @Author wpzhang
 * @Date 2019/3/17
 * @Description
 */
package com.wpzhang.bilibililessons;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-17 21:11
 **/
public class TestEncasulation {
    public static void main(String[] args) {
        Human h = new Human();
        h.id = "340823......";
        h.name = "章吴萍";
        //关于默认情况下的成员访问控制权限
        //此时在不同类里，只能访问到public修饰的成员变量和protected修饰的成员变量
       h.gender="女";
      // h.nAndWeight();  此时是private修饰的类
    }
}