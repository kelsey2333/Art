/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: I型积木块
 * @author: wpzhang
 * @create: 2019-03-19 15:39
 **/
public class TetrominoI extends Tetromino {
    public TetrominoI(int row, int col, Image backImg){
        super(row, col, backImg);
        //初始化数组
        cells[0] = new Cell(row, col, backImg);
        cells[1] = new Cell(row+1, col, backImg);
        cells[2] = new Cell(row+2, col, backImg);
        cells[3] = new Cell(row+3, col, backImg);
    }

}