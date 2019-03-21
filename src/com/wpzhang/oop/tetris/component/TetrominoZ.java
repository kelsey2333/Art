/**
 * @Author wpzhang
 * @Date 2019/3/20
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: Z型方块
 * @author: wpzhang
 * @create: 2019-03-20 18:23
 **/
public class TetrominoZ extends Tetromino {
    // 积木当前状态形状常量
    private static final int STAND  = 1;
    private static final int SIT  = 2;

    // 表示当前积木的形状, 该值只能从上面的四种常量值中去取
    private int state;

    /**
     * @Param row={}, col={}
     * @description 构造器初始化, 确定中心点位置, 初始化cells数组中四个元素
     * @date 2019/3/19 0019 10:14
     * @return
     */
    public TetrominoZ(int row, int col, Image backImg) {

    // 显式调用父类构造器
        super(row, col, backImg);

    // 初始化数组中的四个元素
    cells[0] = new Cell(row, col, backImg);
    cells[1] = new Cell(row, col-1 , backImg);
    cells[2] = new Cell(row + 1, col , backImg);
    cells[3] = new Cell(row + 1, col + 1, backImg);

    // 设置当前积木的状态
    state = STAND;
}

    // 重写父类翻转方法
    @Override
    public void rotate(boolean dir) {
        switch (state) {
            case STAND:
                // STAND -> SIT
                // 初始化数组中的四个元素
                if (dir) {
                    // dir为true:向右翻转
                    cells[1] = new Cell(cells[0].row+1 , cells[0].col+1, backImg);
                    cells[2] = new Cell(cells[0].row -1, cells[0].col, backImg);
                    cells[3] = new Cell(cells[0].row , cells[0].col + 1, backImg);
                    state = SIT;
                } else {
                    // dir为false:向左翻转
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(row, col-1 , backImg);
                    cells[2] = new Cell(row + 1, col , backImg);
                    cells[3] = new Cell(row + 1, col + 1, backImg);
                    state = STAND;
                }
                break;
            case SIT:
                // SIT -> DOWN
                if (dir) {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(row, col-1 , backImg);
                    cells[2] = new Cell(row + 1, col , backImg);
                    cells[3] = new Cell(row + 1, col + 1, backImg);
                    state = STAND;
                } else {
                    // 初始化数组中的四个元素
                    cells[1] = new Cell(cells[0].row+1 , cells[0].col+1, backImg);
                    cells[2] = new Cell(cells[0].row -1, cells[0].col, backImg);
                    cells[3] = new Cell(cells[0].row , cells[0].col + 1, backImg);
                    state = SIT;
                }
                break;
        }
    }
}