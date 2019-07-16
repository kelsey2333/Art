/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: J方法
 * @author: wpzhang
 * @create: 2019-03-13 19:29
 **/
public class J {
    //初始中心位置：定义成员变量
    int row;
    int col;
    Cell[] cells;
    //J方法构造器
    public J(int row,int col) {
        this.row = row;
        this.col = col;

        //成员变量初始赋值
        cells = new Cell[4];

        // 对4块积木单元格进行初始化
        cells[0] = new Cell(this.row, this.col);
        cells[1] = new Cell(this.row+1, this.col );
        cells[2] = new Cell(this.row +2, this.col);
        cells[3] = new Cell(this.row+2, this.col -1);
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
}