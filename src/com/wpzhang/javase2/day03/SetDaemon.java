/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-09 15:43
 **/
public class SetDaemon {
    public static void main(String[] args) throws InterruptedException {

        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(6000);
                        System.out.println("后台线程");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        d.setDaemon(true);
        d.start();
        Thread.sleep(5000);
        System.out.println("main线程结束了");
    }
}