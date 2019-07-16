/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

import com.wpzhang.oop.day03.Cell;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 子类继承父类
 * @author: wpzhang
 * @create: 2019-03-14 13:31
 **/
public class Tetromino {
    int row;
    int col;

    //创建数组对象
    Cell[] cells = new Cell[4];

    //父类构造器，构造器里对数组对象进行初始化。只是初始化，后期J L型对cell[0],cell[1],cell[2]还会改变，但是必须进行初始化
    public Tetromino() {
        cells = new Cell[4];
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row, col + 2);
        cells[3] = new Cell(row + 1, col);
    }

    //构造打印输出方法
    public void print() {
        int rowCount = 10;
        int colCount = 10;
        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                boolean isCell = false;
                for (int i = 0; i < cells.length; i++) {
                    if (col == cells[i].col & row == cells[i].row) {
                        isCell = true;
                    }
                }
                if (isCell) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public void Drop() {
        //必须对所有单元格内进行遍历才能实现整体下落
        for (int i = 0; i < cells.length; i++) {
            cells[i].row++;
        }
    }

    public void moveLeft(int step) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col -= step;
        }
    }

    public void moveRight(int step) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].col += step;
        }
    }

    //构造移动方法
    public void move() {
        //Todo  1、绘制面板，包括积木单元格
        System.out.println("1-下移，2-左移，3-右移");
        while (true) {

            //Todo  2、接受用户输入，控制积木运动
            Scanner scan = new Scanner(System.in);
            //Todo  3、输入0：退出游戏
            int input = scan.nextInt();
            if (input == 0) {
                System.out.println("退出游戏");
                break;
            }
            //Todo  4、输入1,2,3：修改单元格的行列坐标表示下移左移右移

            switch (input) {
                case 1:

                    Drop();
                    break;
                case 2:
                    moveLeft(1);
                    break;
                case 3:
                    moveRight(1);
                default:
                    Drop();
            }
            print();
        }
    }
}

