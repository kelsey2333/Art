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


        private static final int STAND  = 1;
        private static final int SIT  = 2;

        // 表示当前积木的形状, 该值只能从上面的四种常量值中去取
        private int state;
    public TetrominoI(int row, int col, Image backImg){
        super(row, col, backImg);
        //初始化数组
        cells[0] = new Cell(row, col, backImg);
        cells[1] = new Cell(row+1, col, backImg);
        cells[2] = new Cell(row+2, col, backImg);
        cells[3] = new Cell(row+3, col, backImg);
        state  = STAND;
    }
    public void rotate(boolean dir) {
        switch (state) {
            case STAND:
                // SIT -> STAND
                // 初始化数组中的四个元素
                if (dir) {
                    // dir为true:向右翻转
                    cells[1] = new Cell(cells[0].row , cells[0].col+1, backImg);
                    cells[2] = new Cell(cells[0].row , cells[0].col+2, backImg);
                    cells[3] = new Cell(cells[0].row , cells[0].col + 3, backImg);
                    state = SIT;
                } else {
                    // dir为false:向左翻转
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(row+1, col, backImg);
                    cells[2] = new Cell(row+2, col, backImg);
                    cells[3] = new Cell(row+3, col, backImg);
                    state = STAND;
                }
                break;
            case SIT:
                // STAND -> SIT
                // 初始化数组中的四个元素
                if (dir) {
                    // dir为true:向右翻转
                    cells[1] = new Cell(row, col+1, backImg);
                    cells[2] = new Cell(row, col+2, backImg);
                    cells[3] = new Cell(row, col+3, backImg);
                    state = STAND;
                } else {
                    // dir为false:向左翻转
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row , cells[0].col+1, backImg);
                    cells[2] = new Cell(cells[0].row , cells[0].col+2, backImg);
                    cells[3] = new Cell(cells[0].row , cells[0].col + 3, backImg);
                    state = SIT;
                }
                break;
        }
    }
}