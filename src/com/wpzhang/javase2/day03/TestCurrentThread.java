/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description: 测试currentThread方法
 * @author: wpzhang
 * @create: 2019-04-09 15:27
 **/
public class TestCurrentThread {
    //在方法testCurrent中输出当前线程
    public static void testCurrent(){
        Thread th1 = Thread.currentThread();
        System.out.println(th1);
    }
//在main方法中输出当前线程
    public static void main(String[] args) {
      testCurrent();
        //在main方法中创建内部类，输出当前线程
        Thread th3 =new Thread(new Runnable() {
            @Override
            public void run() {
                //当把testCurrent方法设为静态的时候可以在本类中调用
                testCurrent();
            }
        });
        th3.start();
    }
}