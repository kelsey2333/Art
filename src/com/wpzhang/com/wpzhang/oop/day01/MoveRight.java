/**
 * @Author wpzhang
 * @Date 2019/3/12
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day01;

import javafx.scene.control.Cell;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-12 22:04
 **/
public class MoveRight {
    int row;
    int col;
    public static int WithParam(int col2) {
        return(col2);
    }
    public void MoveR() {
        System.out.println(col+=1);
    }



    public static void main(String[] args) {
        int length = 20;
        int width = 30;
        MoveRight moveRight = new MoveRight();
        moveRight.col = 5;
        moveRight.row = 5;
        moveRight.MoveR();
        System.out.println("cell的位置为:" + "(" + moveRight.row + "," + moveRight.col + ")");
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                if (moveRight.row == i && j == moveRight.col) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print("_" + " ");
                }
            }
            System.out.println();
        }


    }
}