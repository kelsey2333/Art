/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

/**
 * @program: Wpzhang
 * @description: 票务 TODO 锁对象和锁方法两个等价吗？？
 * @author: wpzhang
 * @create: 2019-04-10 14:48
 **/
public class Ticket {

    private int num = 100;
//    public synchronized  void sellTicket(){
//        if (!isSellOut()){
//            System.out.println(Thread.currentThread().getName() + "当前票号为：" + num);
//            num --;
//        }
//    }
    //等价于：
    public void sellTicket(){
        synchronized (this) {
            if (!isSellOut()) {
                System.out.println(Thread.currentThread().getName() + "当前票号为：" + num);
                num--;
            }
        }
    }
    public boolean isSellOut(){
        if (num <= 0){
            return true;
        }
        return false;
    }
}