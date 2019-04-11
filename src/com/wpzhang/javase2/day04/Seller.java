/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

/**
 * @program: Wpzhang
 * @description: 代售点
 * @author: wpzhang
 * @create: 2019-04-10 14:55
 **/
public class Seller extends Thread {
    private Ticket ticket;
    public Seller(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run() {
        while(!ticket.isSellOut()) {
//            synchronized (ticket){
                ticket.sellTicket();
//            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}