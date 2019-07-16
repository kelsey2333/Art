/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

/**
 * @program: Wpzhang
 * @description: O型继承父类
 * @author: wpzhang
 * @create: 2019-03-14 16:34
 **/
public class TetrominoO extends Tetromino {
    //O型要有一个自己的构造器
    public TetrominoO(int row, int col) {
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1);
        cells[2] = new Cell(row + 1, col);
        cells[3] = new Cell(row + 1, col + 1);

    }
}