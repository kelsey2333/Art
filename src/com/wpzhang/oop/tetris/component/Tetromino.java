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
public abstract class Tetromino {
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
        row++;
    }
    //为什么要对drop方法进行重写？因为当方块撞击到墙时需要回退一步
    public void drop(int step ) {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].drop(step);
        }
        row += step;
    }

    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveLeft();
        }
    }
    public void moveLeft(int step) {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveLeft(step);
        }
        col -= step;
    }

    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveRight();
        }
    }
    public void moveRight(int step) {
        for (int i = 0; i < cells.length; i++) {
            // 循环移动4个积木单元格
            cells[i].moveRight(step);
        }
        col += step;
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
    /**
     * @Param
     * @description 翻转方法
     * @date 2019/3/20 14:05
     * @return
     */


    /*
    知识点：由abstract修饰的方法是抽象方法（类中包含抽象方法该类必须申明为抽象类）
    abstract修饰的抽象类不继承将毫无意义
    继承该类后进行方法的重写
     */
    /*
    此处的rotate翻转方法：每块方块都要进行翻转，但是翻转的方法不同
     */
    public abstract void rotate(boolean dir);


}
