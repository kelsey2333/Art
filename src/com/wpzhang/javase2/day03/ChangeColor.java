/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

import javax.swing.*;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 改变窗体颜色
 * @author: wpzhang
 * @create: 2019-04-09 14:44
 **/
public class ChangeColor {
    public static void main(String[] args) {
        //设置窗体属性
        JFrame jf = new JFrame("颜色切换");
        jf.setSize(300, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);


        /*
        使用方式2创建线程：
        */
//        Thread th1 = new Thread(new ColorRunnable(jf));
//        th1.start();
        /*
        使用方式3：匿名内部类创建线程：
         */
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isBlack = true;
                while(true){
                    if (isBlack) {
                        jf.getContentPane().setBackground(Color.BLACK);
                    }else {
                        jf.getContentPane().setBackground(Color.WHITE);
                    }
                    isBlack = !isBlack;
                    }
                }

        });
        th1.start();
    }
}


class ColorRunnable implements Runnable {
    /*
    在一个类中调用main函数中的对象
     */
    private JFrame jf;

    public ColorRunnable(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void run() {
        boolean black = true;
        while (true) {
            if (black) {
                jf.getContentPane().setBackground(Color.BLACK);
            } else {
                jf.getContentPane().setBackground(Color.WHITE);
            }
            black = !black;//反转
        }
    }

}
