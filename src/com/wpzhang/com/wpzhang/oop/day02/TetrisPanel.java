/**
 * @Author wpzhang
 * @Date 2019/3/12
 * @Description
 */
package com.wpzhang.com.wpzhang.oop.day02;

/**
 * @program: Wpzhang
 * @description: 俄罗斯方块面板
 * @author: wpzhang
 * @create: 2019-03-12 16:32
 **/
public class TetrisPanel {
    public static void main(String[] args) {
        cell c = new cell();
        c.row =7;
        c.col= 8;
        c.drop();
        c.moveLeft();
        c.length = 30;
        c.width = 20;
        c.addL();

        }
    }

