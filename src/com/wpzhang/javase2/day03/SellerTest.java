/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description:模拟售票
 * @author: wpzhang
 * @create: 2019-04-09 16:17
 **/
public class SellerTest {
    public static Integer ticketNum = 100;

    public static void main(String[] args) {
    Runnable task = new Runnable() {
        @Override
        public void run() {
            while(true){
                synchronized (ticketNum) {
                    if (ticketNum < 1) {
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前卖出的票号为：" + ticketNum);
                    ticketNum--;
                }
                //锁解除
            }
        }
    };
    Thread th1 = new Thread(task);
    Thread th2 = new Thread(task);
    Thread th3 = new Thread(task);

    th1.start();
    th2.start();
    th3.start();
    }
}

