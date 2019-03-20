/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;

import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 四格积木
 * @author: wpzhang
 * @create: 2019-03-19 14:06
 **/
public class Tetromino {
    public Tetromino() {
        row = 1;
        col = 1;
        cells = new Cell[4];
    }

    public Tetromino(int row, int col, Image backImg) {
        this.row = row;
        this.col = col;
        cells = new Cell[4];
        this.backImg = backImg;
    }

    // 中心点坐标
    int row;
    int col;

    // 四个积木单元格数组
    Cell[] cells;

    // 四格拼版的背景图片
    Image backImg;

    public void drop() {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].drop();
        }
    }

    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveLeft();
        }
    }

    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveRight();
        }
    }

    /**
     * @return void
     * @Param g={}
     * @description 四格拼版绘制方法
     * @date 2019/3/19 0019 10:11
     */
    public void paint(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            // 循环绘制4个积木单元格
            cells[i].paint(g);
        }
    }

    /**
     * @return void
     * @Param g={画笔}, x={基于当前像素点未知的x轴偏移量}, y={y轴偏移量}
     * @description TODO 描述功能
     * @date 2019/3/19 0019 10:45
     */
    public void paint(Graphics g, int x, int y) {
        for (int i = 0; i < cells.length; i++) {
            // 根据偏移量x,y绘制积木单元格
            cells[i].paint(g, x, y);
        }
    }
}
