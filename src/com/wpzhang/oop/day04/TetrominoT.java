/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day04;

/**
 * @program: Wpzhang
 * @description: 子类T继承父类
 * @author: wpzhang
 * @create: 2019-03-14 13:58
 **/
public class TetrominoT extends Tetromino {
    //TetrominoT构造器，并且对T型积木单元格进行初始化（相当于对数组中的成员变量进行初始化）
    public TetrominoT(int row, int col) {
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row, col + 2);
        cells[3] = new Cell(row + 1, col + 1);
    }

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
}

