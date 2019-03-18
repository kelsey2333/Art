/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day04.Homework;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-14 14:16
 **/
public class GamePanel {
    public static void main(String[] args) {
        //创建T、L、O、J、I、S积木单元格对象
        TetrominoT tCell = new TetrominoT(5, 1);
        tCell.print();
        TetrominoT move = new TetrominoT(5, 1);
        move.move();
    }
}
