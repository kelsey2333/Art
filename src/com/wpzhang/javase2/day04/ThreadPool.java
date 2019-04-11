/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Wpzhang
 * @description: 线程池
 * @author: wpzhang
 * @create: 2019-04-10 15:1
 **/
public class ThreadPool {
    public static void main(String[] args) {
        /*
        1、创建线程任务：每隔一秒钟输出当前线程的名字，一共输出10次
        2、创建一个线程池，一共只有5个空线程
        3、使线程执行5次步骤1
         */
        //1、创建线程任务：每隔一秒钟输出当前线程的名字，一共输出10次
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //2、创建一个线程池，一共只有5个空线程
        ExecutorService es = Executors.newFixedThreadPool(5);
        //3、使线程执行5次步骤1
        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
        es.shutdown();
    }
}