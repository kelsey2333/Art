/**
 * @Author wpzhang
 * @Date 2019/3/13
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: 绘制面板
 * @author: wpzhang
 * @create: 2019-03-13 15:57
 **/
public class GamePanel {

    public static void main(String[] args) {
        J jCells = new J (7, 7);
        jCells.print(jCells);
        T tCells = new T(9,9);
        tCells.print(tCells);
        O oCells = new O(6,6);
        oCells.print(oCells);
        L lCells = new L(8,8);
        lCells.print(lCells);

    }
}