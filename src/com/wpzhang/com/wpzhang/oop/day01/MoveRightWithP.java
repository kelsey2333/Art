/**
 * @Author wpzhang
 * @Date 2019/3/12
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day01;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 传入参数右移
 * @author: wpzhang
 * @create: 2019-03-12 22:40
 **/
public class MoveRightWithP {
    public static void main(String[] args) {
        int length = 20;
        int width = 30;
        MoveRight moveRight2 = new MoveRight();
        moveRight2.col = 5;
        moveRight2.row = 5;

        MoveRight.WithParam(4);
        moveRight2.col+=4;

        System.out.println("cell的位置为:" + "(" + moveRight2.row + "," + moveRight2.col + ")");
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                if (moveRight2.row == i && j == moveRight2.col) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print("_" + " ");
                }
            }
            System.out.println();
        }
    }
}
