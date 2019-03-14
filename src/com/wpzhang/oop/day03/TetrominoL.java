/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

/**
 * @program: Wpzhang
 * @description: L子类继承父类
 * @author: wpzhang
 * @create: 2019-03-14 16:16
 **/
public class TetrominoL extends Tetromino {

    public TetrominoL(int row, int col) {
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row+1, col );
        cells[2] = new Cell(row+2, col );
        cells[3] = new Cell(row + 2, col + 1);
    }
}