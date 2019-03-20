/**
 * @Author wpzhang
 * @Date 2019/3/19
 * @Description
 */
package com.wpzhang.oop.tetris.component;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 积木单元块
 * @author: wpzhang
 * @create: 2019-03-19 13:37
 **/
public class Cell {
    /**
     * 构造器初始化
     * @param row
     * @param col
     * @param backImg
     */
    public Cell(int row, int col, Image backImg) {
        this.row = row;
        this.col = col;
        this.backImg = backImg;
    }

    // 表示积木单元格在游戏面板上的坐标位置
    int row;
    int col;

    // 积木单元格的背景图片
    Image backImg;


    public void drop() {
        row ++;
    }

    public void moveLeft() {
        col --;
    }

    public void moveRight() {
        col ++;
    }

    public void paint(Graphics g, int x , int y) {
        g.drawImage(backImg,            // 背景图片
                (col - 1) * backImg.getHeight(null) + 15 + x,   // x坐标
                (row - 1) * backImg.getWidth(null) + 15 + y,    // y坐标
                null);  // null值
    }

    public void paint(Graphics g) {
        g.drawImage(backImg,            // 背景图片
                (col - 1) * backImg.getHeight(null) + 15,   // x坐标
                (row - 1) * backImg.getWidth(null) + 15,    // y坐标
                null);  // null值
    }

}