/**
 * @Author wpzhang
 * @Date 2019/4/11
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-11 19:40
 **/
public class SynAndWait implements Runnable {
    @Override
    public void run() {
        printNum();
        printLetters();
    }
    Object lock = new Object();
    public  void printNum() {
        for (int i = 1; i <= 52; i++) {
            System.out.println(i);
            if (i % 2 == 0){
                System.out.println();
            }
        }
    }
    public void printLetters(){
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (char c = 'A'; c <= 'Z' ; c++) {
            System.out.println(c);
        }
    }
}