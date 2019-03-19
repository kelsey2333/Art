/**
 * @Author wpzhang
 * @Date 2019/3/18
 * @Description
 */
package com.wpzhang.bilibililessons.reviewtetromino2;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-18 20:24
 **/
public class main3 {
    public static void main(String[] args) {
        Tetromino3 O = new  Tetromino3(2,4);
        O.print();
        Tetromino3 move = new Tetromino3(2,4);
        move.move();
    }
}