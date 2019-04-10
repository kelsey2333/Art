/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day03;

/**
 * @program: Wpzhang
 * @description: 创建线程
 * @author: wpzhang
 * @create: 2019-04-09 14:17
 **/
public class CreatThreadTest {
    /*
   创建线程方式1：
       -使用自定义类继承Thread类，重写run方法（run相当于线程任务）
     */
    public static void main(String[] args) {
//        MyThread th1 = new MyThread();
//        MyThread th2 = new MyThread();
//        //启动线程
//        th1.start();
//        th2.start();
    /*
    创建方式2：
      -自定义接口实现类实现runnable接口，重写run方法
      -创建Thread对象，使用构造器Threa(Runnable task)
     */
//    Thread th1 = new Thread(new MyRunnable());
//    Thread th2 = new Thread(new MyRunnable());
//    th1.start();
//    th2.start();

       /*
       创建方式3：
          - 使用匿名内部类
       */
       Thread th1 = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 1; i <= 100 ; i++) {
                   System.out.println(i);
               }
           }
       });
       Thread th2 = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 1; i <= 100 ; i++) {
                   System.out.println(i);
               }
           }
       });
       th1.start();
       th2.start();
    }

}