/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

/**
 * @program: Wpzhang
 * @description: J子类继承父类
 * @author: wpzhang
 * @create: 2019-03-14 16:43
 **/
public class TetrominoJ extends Tetromino {
    public TetrominoJ(int row,int col){
        //对四块积木单元格进行初始化
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row+1, col);
        cells[2] = new Cell(row+2, col);
        cells[3] = new Cell(row+2, col-1);

    }
}