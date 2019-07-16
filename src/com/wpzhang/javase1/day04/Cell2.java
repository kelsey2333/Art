/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day04;

/**
 * @program: Wpzhang
 * @description: Cell测试
 * @author: wpzhang
 * @create: 2019-04-01 18:23
 **/
public class Cell2 {
    int row;
    int col;

    public Cell2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void drop() {
        row++;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}
