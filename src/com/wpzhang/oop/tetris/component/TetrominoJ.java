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
    // 积木当前状态形状常量
    private static final int DOWN3   = 1;
    private static final int RIGHT3  = 2;
    private static final int UP3    = 3;
    private static final int LEFT3   = 4;

    // 表示当前积木的形状, 该值只能从上面的四种常量值中去取
    private int state;

    public TetrominoJ(int row, int col, Image backImg){
        //显示父类构造器
        super(row,col,backImg);
        //初始化数组的四个元素

        cells[0]= new Cell(row, col, backImg);
        cells[1] = new Cell(row, col-1, backImg);
        cells[2] = new Cell(row-1, col, backImg);
        cells[3] = new Cell(row-2, col, backImg);
        state = DOWN3;

    }
    public void rotate(boolean dir) {
        switch (state) {
            case DOWN3:
                // DOWN3 -> RIGHT3
                // 初始化数组中的四个元素
                if (dir) {
                    // dir为true:向右翻转
                    cells[1] = new Cell(cells[0].row, cells[0].col - 1, backImg);
                    cells[2] = new Cell(cells[0].row, cells[0].col - 2, backImg);
                    cells[3] = new Cell(cells[0].row + 1, cells[0].col, backImg);
                    state = RIGHT3;
                } else {
                    // dir为false:向左翻转
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImg);
                    cells[2] = new Cell(cells[0].row, cells[0].col + 2, backImg);
                    cells[3] = new Cell(cells[0].row - 1, cells[0].col, backImg);
                    state = LEFT3;
                }
                break;
            case RIGHT3:
                // RIGHT -> UP
                if (dir) {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImg);
                    cells[2] = new Cell(cells[0].row + 1, cells[0].col, backImg);
                    cells[3] = new Cell(cells[0].row + 2, cells[0].col, backImg);
                    state = UP3;
                } else {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(row, col - 1, backImg);
                    cells[2] = new Cell(row - 1, col, backImg);
                    cells[3] = new Cell(row - 2, col, backImg);
                    state = DOWN3;
                }
                break;
            case UP3:
                // UP -> LEFT{
                if (dir) {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImg);
                    cells[2] = new Cell(cells[0].row, cells[0].col + 2, backImg);
                    cells[3] = new Cell(cells[0].row - 1, cells[0].col, backImg);
                    state = LEFT3;
                } else {
                    cells[1] = new Cell(cells[0].row, cells[0].col - 1, backImg);
                    cells[2] = new Cell(cells[0].row, cells[0].col - 2, backImg);
                    cells[3] = new Cell(cells[0].row + 1, cells[0].col, backImg);
                    state = RIGHT3;
                }
                break;
            case LEFT3:
                // LEFT -> DOWN
                if (dir) {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(row, col - 1, backImg);
                    cells[2] = new Cell(row - 1, col, backImg);
                    cells[3] = new Cell(row - 2, col, backImg);
                    state = DOWN3;
                } else {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row, cells[0].col + 1, backImg);
                    cells[2] = new Cell(cells[0].row + 1, cells[0].col, backImg);
                    cells[3] = new Cell(cells[0].row + 2, cells[0].col, backImg);
                    state = UP3;
                }
                break;
        }
    }
}