/**
 * @Author wpzhang
 * @Date 2019/3/18
 * @Description
 */
package com.wpzhang.bilibililessons.reviewtetromino2;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 俄罗斯方块
 * @author: wpzhang
 * @create: 2019-03-18 19:38
 **/
public class Tetromino3 {
    int row;
    int col;
    //创建数组对象
    Cell3 cells[] = new Cell3[4];

    public Tetromino3(int row ,int col) {
        this.row = row;
        this.col = col;
        //给数组元素进行初始化
        cells[0] = new Cell3(row, col);
        cells[1] = new Cell3(row, col + 1);
        cells[2] = new Cell3(row, col + 2);
        cells[3] = new Cell3(row + 1, col + 1);
    }

    //drop方法
    public void drop(int step) {
        //对每一个积木单元格都要进行移动
        for (int i = 0; i < cells.length; i++) {
            cells[i].row++;
        }
    }

    //moveLeft方法
    public void moveLeft(int step) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col -= step;
        }
    }

    //moveRight方法
    public void moveRight(int step) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col += step;
        }
    }

    //print方法


    public void print() {
        int rowCount = 10;
        int colCount = 10;
        for (int row = 1; row <= rowCount; row++) {
            for (int col = 1; col <= colCount; col++) {
                boolean iscell = false;
                for (int i = 0; i < cells.length; i++) {
                    if (cells[i].row == row && cells[i].col == col) {
                        iscell = true;
                    }
                }
                    if (iscell == true) {
                        System.out.print("* ");
                    } else {
                        System.out.print("- ");
                    }

            }
            System.out.println();
        }
        print();
    }

    //整体移动方法
    public void move() {
        //0-退出游戏  1-下移  2-左移  3-右移
        System.out.println("0-退出游戏  1-下移  2-左移   3-右移");

        while (true) {
            //循环接收用户输入
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            //输入0：则退出游戏
            if (input == 0) {
                System.out.println("退出游戏");
                break;
            } else {
                switch (input) {
                    //输入1：则下移
                    case 1:
                        drop(1);
                        break;
                    //输入2：则左移
                    case 2:
                        moveLeft(1);
                        break;
                    //输入3：则右移
                    case 3:
                        moveRight(1);
                        break;
                    default:
                }
            }
        }

    }
}



