/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-13 20:15
 **/
public class JGamePanel {
    public static void main(String[] args) {
        //定义面板行列
        int rowCount = 20;
        int colCount = 10;
        //创建单元格对象（找到T类）
        J jCells = new J(7, 9);

        //在main方法中执行程序，所以在main方法中遍历
        //绘制面板

        for (int row = 1; row <= rowCount; row++) {
            //绘制第一行
            for (int col = 1; col <= colCount; col++) {
                //对4个积木单元格进行遍历
                boolean isCell = false;
                for (int i = 0; i < jCells.cells.length; i++) {
                    if (jCells.cells[i].row== row && jCells.cells[i].col == col) {
                        isCell = true;
                    }
                }
                if (isCell) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}