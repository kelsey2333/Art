/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import com.wpzhang.oop.tetris.component.Cell;
import com.wpzhang.oop.tetris.component.Tetromino;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: J型积木
 * @author: wpzhang
 * @create: 2019-03-19 15:09
 **/
public class TetrominoJ extends Tetromino {
    public TetrominoJ(int row, int col, Image backImg){
        //显示父类构造器
        super(row,col,backImg);
        //初始化数组的四个元素

        cells[0]= new Cell(row, col, backImg);
        cells[1] = new Cell(row+1, col, backImg);
        cells[2] = new Cell(row+2, col, backImg);
        cells[3] = new Cell(row+2, col-1, backImg);

    }
}