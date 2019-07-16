/**
 * @Author wpzhang
 * @Date 2019/3/14
 * @Description
 */
package com.wpzhang.oop.day03;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-14 14:16
 **/
public class GamePanel {
    public static void main(String[] args) {
        TetrominoT tCell = new TetrominoT(2, 5);
        tCell.print();
        TetrominoO oCell = new TetrominoO(2, 3);
        oCell.print();
        TetrominoJ jCell = new TetrominoJ(2, 2);
        jCell.print();
        TetrominoI iCell = new TetrominoI(5, 4);
        iCell.print();
        TetrominoS sCell = new TetrominoS(4, 3);
        sCell.print();
        Tetromino move = new Tetromino();
        move.move();
    }
}
