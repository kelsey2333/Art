/**
 * @Author wpzhang
 * @Date 2019/3/18
 * @Description
 */
package com.wpzhang.bilibililessons.reviewtetromino;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 俄罗斯方块
 * @author: wpzhang
 * @create: 2019-03-18 08:30
 **/
public class Tetromino2 {
    int row;
    int col;
    Cell2[] cells = new Cell2[4];
 public Tetromino2(){
     cells[0] = new Cell2(row, col);
     cells[1] = new Cell2(row, col + 1);
     cells[2] = new Cell2(row, col + 2);
     cells[3] = new Cell2(row + 1, col + 1);
 }

    //俄罗斯方块方法构造器：数组形式
    //创建数组对象


    //构造打印输出方法
    public void print() {
        int rowCount = 10;
        int colCount = 10;
        for (int row = 1; row <= rowCount; row++) {
            for (int col = 1; col <= colCount; col++) {
                //对四个单元格进行遍历
                boolean isCell = false;
                for (int i = 0; i < cells.length; i++) {
                    if (row == cells[i].row & col == cells[i].col) {
                        isCell = true;
                    }
                }
                if (isCell == true) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

    }

    //下移方法
    public void Drop(int step) {
        for (int i= 0;i<cells.length;i++) {
           cells[i].row++;
        }
    }

    //左移方法
    public void moveLeft(int step) {
        for(int i = 0;i<cells.length;i++) {
            cells[i].col -= step;
        }
    }

    //右移方法
    public void moveRight(int step) {
        for(int i = 0;i<cells.length;i++) {
           cells[i].col += step;
        }
    }

    //键盘控制移动方法
    public void move() {
        //循环接收用户输入，控制积木运动
        System.out.println("0-退出游戏 ，1-下移，2-左移，3-右移");
        while (true) {
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            //输入0：退出游戏,退出游戏不参与循环
            if (input == 0) {
                System.out.println("退出游戏");
                break;
            }
            //输入1,2,3：分别下移左移右移
            switch (input) {
                case 1:
                    Drop(1);
                    break;
                case 2:
                    moveLeft(1);
                    break;
                case 3:
                    moveRight(1);
                    break;
            }
            print();
        }
    }

}