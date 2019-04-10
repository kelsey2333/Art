/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description: 合并线程
 * @author: wpzhang
 * @create: 2019-04-09 16:04
 **/
public class JoinTest {
    public static void main(String[] args) {
        //下载图片线程
        Thread downTh = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("已下载" + i + "%");
                }
            }
        });
        //显示图片线程（显示图片前要等待下载图片完毕）
        Thread showTh = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //该方法表示要等待当前线程结束
                    downTh.join();
                    System.out.println("显示图片");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        downTh.start();
        showTh.start();
    }
}