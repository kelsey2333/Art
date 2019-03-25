/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: 积木单元块
 * @author: wpzhang
 * @create: 2019-03-13 13:17
 **/
public class Cell {
    int row;
    int col;

    public Cell(int row, int col) {//有参构造方法
        this.row = row;
        this.col = col;
    }
    //单元格下落：drop方法
    public void Drop() {
        row++;
    }

    //单元格左移：设置移动步数
    public void moveLeft(int step) {
        col -= step;
    }
    public void moveRight(int step) {
        col += step;
    }

    //获取单元格位置信息
    public void print() {
        System.out.println("row:" + row + "  col:" + col);
    }

}