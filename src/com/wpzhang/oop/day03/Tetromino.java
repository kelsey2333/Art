/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

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
    Cell[] cells;


    //父类构造器，构造器里对数组对象进行初始化
    public Tetromino() {
        cells = new Cell[4];
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[0] = new Cell(row, col + 2);
        cells[0] = new Cell(row + 1, col);
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

    //
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


}

