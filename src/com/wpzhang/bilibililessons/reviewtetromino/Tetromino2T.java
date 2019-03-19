/**
 * @Author wpzhang
 * @Date 2019/3/18
 * @Description
 */
package com.wpzhang.bilibililessons.reviewtetromino;

import com.wpzhang.oop.day03.Cell;

/**
 * @program: Wpzhang
 * @description: T型积木单元块
 * @author: wpzhang
 * @create: 2019-03-18 11:26
 **/
public class Tetromino2T extends Tetromino2 {
    public Tetromino2T(int row,int col) {
        cells = new Cell2[4];
        cells[0] = new Cell2(row, col);
        cells[1] = new Cell2(row, col + 1);
        cells[2] = new Cell2(row, col + 2);
        cells[3] = new Cell2(row + 1, col + 1);
    }
}