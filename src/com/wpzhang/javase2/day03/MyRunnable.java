/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description: 自定义接口实现类、
 * @author: wpzhang
 * @create: 2019-04-09 14:30
 **/
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            System.out.println(i);
        }
    }
}