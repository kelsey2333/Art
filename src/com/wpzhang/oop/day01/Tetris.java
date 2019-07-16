/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day01;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 单元块
 * @author: wpzhang
 * @create: 2019-03-13 12:58
 **/
public class Tetris {

    public static void main(String[] args) {

        //面板行列
        int rowCount = 10;
        int colCount = 10;
        //初始化积木单元格
        Cell cell = new Cell(5,1);
        //循环接收用户输入，控制积木上下移动

        //Todo  1、绘制面板，包括积木单元格
        System.out.println("1-下移，2-左移，3-右移");
        while (true) {
            paintPanel(rowCount, colCount, cell);

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
                    cell.Drop();
                    break;
                case 2:
                    cell.moveLeft(1);
                    break;
                case 3:
                    cell.moveRight(1);
                default:
                    cell.Drop();
            }
        }

    }

    public static void paintPanel(int rowCount, int colCount, Cell cell) {
        for (int row = 1; row <= rowCount; row++) {
            for (int col = 1; col <= colCount; col++) {
                if (cell.col == col && cell.row == row) {
                    System.out.print("* ");

                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();

        }  System.out.println("row:"+cell.row+" col:"+cell.col);

    }
}
