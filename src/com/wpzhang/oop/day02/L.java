/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: L型积木单元块
 * @author: wpzhang
 * @create: 2019-03-13 22:59
 **/
public class L {
    int row;
    int col;
    Cell[] cells;
    public L(int row,int col){
        this.row= row;
        this.col = col;
        cells = new Cell[4];
        cells[0] = new Cell(this.row, this.col);
        cells[1] = new Cell(this.row+1, this.col );
        cells[2] = new Cell(this.row +2, this.col);
        cells[3] = new Cell(this.row+2, this.col +1);
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
    public void drop(){
        for (int i = 0;i<cells.length;i++){
            cells[i].Drop();
        }
    }

}