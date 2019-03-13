/**
 * @Author wpzhang
 * @Date 2019/3/12
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day02;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 小方块成员变量及方法
 * @author: wpzhang
 * @create: 2019-03-12 17:13
 **/
public class cell {
    //定义成员变量：小方块的行坐标
    int row;
    //定义成员变量：小方块的列坐标
    int col;
    int length;
    int width;

    //实现小方块的下移
    public void drop() {
        row++;
    }

    //实现小方块的左移
    public void moveLeft() {
        col--;
    }

    public void addL() {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                if (j == row && i == col) {
                    System.out.print("*" +" "+"*"+" "+"*"+" "+"*");
                }if (j ==row+3 && i == col+1) {
                    System.out.print("*" + " ");
                }
                if (j==row+3 && i == col+5) {
                    System.out.print("*" + " "+"*"+" "+"*");
                }if (j ==row+4&& i == col+6) {
                    System.out.print("*" + " ");
                }
                if (j ==row+4&& i == col+7) {
                    System.out.print("*" + " ");
                }if (j ==row+4&& i == col+6) {
                    System.out.print("*" + " "+"*");
                }

                else {
                    System.out.print("_" + " ");
                }
            }
            System.out.println();
        }

    }
}