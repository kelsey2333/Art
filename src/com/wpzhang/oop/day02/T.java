/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: T型单元格
 * @author: wpzhang
 * @create: 2019-03-13 16:06
 **/
public class T {
    // 初始中心点坐标位置：定义成员变量
    int row;
    int col;

    //方法构造器
    public T(int row, int col) {
        this.row = row;
        this.col = col;

        // 对成员变量进行初始化;成员变量是一个
        cells = new Cell[4];

        // 对4块积木单元格进行初始化
        cells[0] = new Cell(this.row, this.col);
        cells[1] = new Cell(this.row, this.col - 1);
        cells[2] = new Cell(this.row + 1, this.col);
        cells[3] = new Cell(this.row, this.col + 1);
    }

    public void print() {

        int rowCount = 20;
        int colCount = 10;
        for (int row = 1; row <= rowCount; row++) {
            //绘制第一行
            for (int col = 1; col <= colCount; col++) {
                //对4个积木单元格进行遍历
                boolean isCell = false;
                for (int i = 0; i < cells.length; i++) {
                    if (cells[i].row == row && cells[i].col == col) {
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

    // 保存4块,积木单元格
    Cell[] cells;
}
