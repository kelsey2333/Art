/**
 * @Author wpzhang
 * @Date 2019/4/11
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description: 创建线程demo
 * @author: wpzhang
 * @create: 2019-04-11 19:37
 **/
public class SynAndWaitTest {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 1; i <= 52; i++) {
                        System.out.print(i);
                        if (i%2==0){
                            lock.notify();
                            System.out.println();
                        }
                    }
                }

            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (char c = 'A';c <= 'Z';c ++){
                        System.out.println(c);
                    }
                }

               }

        });
        th1.start();
        th2.start();
    }
}