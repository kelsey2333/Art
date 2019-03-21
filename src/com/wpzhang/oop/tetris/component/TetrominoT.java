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
 * @description: T型积木
 * @author: wpzhang
 * @create: 2019-03-19 14:09
 **/
public class TetrominoT extends Tetromino {
    /**
     * @return
     * @Param row={}, col={}
     * @description 构造器初始化, 确定中心点位置, 初始化cells数组中四个元素
     * @date 2019/3/19 0019 10:14
     */
    private static final int DOWN2  = 1;
    private static final int RIGHT2  = 2;
    private static final int UP2   = 3;
    private static final int LEFT2   = 4;

    // 表示当前积木的形状, 该值只能从上面的四种常量值中去取
    private int state;


    public TetrominoT(int row, int col, Image backImg) {
        // 显式调用父类构造器
        super(row, col, backImg);

        // 初始化数组中的四个元素
        cells[0] = new Cell(row, col, backImg);
        cells[1] = new Cell(row, col - 1, backImg);
        cells[2] = new Cell(row + 1, col, backImg);
        cells[3] = new Cell(row, col + 1, backImg);
        state = DOWN2;
    }
    public void rotate(boolean dir) {
        //重写父类翻转方法
            switch (state) {
                case DOWN2:
                    // DOWN -> RIGHT
                    // 初始化数组中的四个元素
                    if (dir) {
                        // dir为true:向右翻转
                        cells[1] = new Cell(cells[0].row - 1, cells[0].col, backImg);
                        cells[2] = new Cell(cells[0].row , cells[0].col+1, backImg);
                        cells[3] = new Cell(cells[0].row + 1, cells[0].col , backImg);
                        state = RIGHT2;
                    } else {
                        // dir为false:向左翻转
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(cells[0].row -1 , cells[0].col, backImg);
                        cells[2] = new Cell(cells[0].row , cells[0].col-1, backImg);
                        cells[3] = new Cell(cells[0].row + 1, cells[0].col , backImg);
                        state = LEFT2;
                    }
                    break;
                case RIGHT2:
                    // RIGHT -> UP
                    if (dir) {
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(cells[0].row-1, cells[0].col , backImg);
                        cells[2] = new Cell(cells[0].row, cells[0].col -1 , backImg);
                        cells[3] = new Cell(cells[0].row , cells[0].col + 1, backImg);
                        state = UP2;
                    } else {
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(row, col - 1, backImg);
                        cells[2] = new Cell(row + 1, col, backImg);
                        cells[3] = new Cell(row, col + 1, backImg);
                        state = DOWN2;
                    }
                    break;
                case UP2:
                    // UP -> LEFT{
                    if (dir) {
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(cells[0].row -1 , cells[0].col, backImg);
                        cells[2] = new Cell(cells[0].row , cells[0].col-1, backImg);
                        cells[3] = new Cell(cells[0].row + 1, cells[0].col , backImg);
                        state = LEFT2;
                    } else {
                        cells[1] = new Cell(cells[0].row - 1, cells[0].col, backImg);
                        cells[2] = new Cell(cells[0].row , cells[0].col+1, backImg);
                        cells[3] = new Cell(cells[0].row + 1, cells[0].col , backImg);
                        state = RIGHT2;
                    }
                    break;
                case LEFT2:
                    // LEFT -> DOWN
                    if (dir) {
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(row, col - 1, backImg);
                        cells[2] = new Cell(row + 1, col, backImg);
                        cells[3] = new Cell(row, col + 1, backImg);
                        state = DOWN2;
                    } else {
                        // 初始化数组中的四个元素
                        cells[1] = new Cell(cells[0].row+1, cells[0].col , backImg);
                        cells[2] = new Cell(cells[0].row, cells[0].col -1 , backImg);
                        cells[3] = new Cell(cells[0].row , cells[0].col + 1, backImg);
                        state = UP2;
                    }
                    break;
            }
    }
}