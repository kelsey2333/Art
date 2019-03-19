/**
 * @Author wpzhang
 * @Date 2019/3/18
 * @Description
 */
package com.wpzhang.bilibililessons.reviewtetromino;

/**
 * @program: Wpzhang
 * @description: 程序执行入口
 * @author: wpzhang
 * @create: 2019-03-18 11:23
 **/
public class main {
    public static void main(String[] args) {
        //创建对象
        Tetromino2T T = new Tetromino2T(2, 5);
        T.print();
        Tetromino2T m = new Tetromino2T(2,5);
        m.move();
    }
}