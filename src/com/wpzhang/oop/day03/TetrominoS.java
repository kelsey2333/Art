/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

/**
 * @program: Wpzhang
 * @description: S型子类继承父类
 * @author: wpzhang
 * @create: 2019-03-14 16:53
 **/
public class TetrominoS extends Tetromino {
    public TetrominoS(int row, int col) {
        //对四块积木单元格进行初始化
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row + 1, col);
        cells[3] = new Cell(row + 1, col - 1);
    }
}