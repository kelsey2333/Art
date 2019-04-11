/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

import com.wpzhang.oop.day02.T;

/**
 * @program: Wpzhang
 * @description: 测试代售点
 * @author: wpzhang
 * @create: 2019-04-10 14:58
 **/
public class SellerTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Seller s1 = new Seller(ticket);
        Seller s2 = new Seller(ticket);
        Seller s3 = new Seller(ticket);
        s1.start();
        s2.start();
        s3.start();
    }
}