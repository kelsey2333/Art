/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: S型积木块
 * @author: wpzhang
 * @create: 2019-03-19 16:14
 **/
public class TetrominoS  extends Tetromino{
    public TetrominoS(int row, int col, Image backImg){
        super(row, col, backImg);
        //初始化S型积木数组
        cells[0] = new Cell(row, col, backImg);
        cells[1] = new Cell(row, col+1, backImg);
        cells[2] = new Cell(row+1, col+1, backImg);
        cells[3] = new Cell(row+1, col+2, backImg);

    }

}