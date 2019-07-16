/**
 * @Author wpzhang
 * @Date 2019/4/11
 * @Description
 */
package com.wpzhang.javase2.day05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Wpzhang
 * @description: 服务器  TODO 写出数据不需要线程吗
 * @author: wpzhang
 * @create: 2019-04-11 13:40
 **/
public class Server {
    public static void main(String[] args) throws IOException {

        //1、创建服务器
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器创建成功！");
        //2、建立连接:监听客户端的到来(循环监听)
        while (true) {
            System.out.println("等待客户端的连接...");
            Socket client = server.accept();
            System.out.println("客户端连接成功！");
            /*
             读写都是阻塞方法：在没读到任何内容时会一直阻塞在该代码前
            ，为了不发生阻塞（即使不读取任何内容也能让其他客户端连接到），要让读取放到接收线程中。
            读取在线程中会立即执行完毕。先建立连接，建立连接后，执行线程的start，线程就绪，各线程抢时间片
            抢到时间片的线程读写结束，每次读写会被不同线程执行
             */
            Thread resceiveTh = new Thread(new Runnable() {
                @Override
                public void run() {
                    //3、循环读取数据
                    try {
                        InputStream is = client.getInputStream();
                        OutputStream os = client.getOutputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintWriter pw = new PrintWriter(os, true);

                        while (true) {
                            System.out.println(Thread.currentThread().getName() + br.readLine());
                            /*
                            将写放在了线程里，当要输出到多个客户端的时候就要多线程，er客户端
                            不需要多线程写出，因为他写出只会写出服务器。
                             */

                            pw.println("我收到了！");
                        }
                    } catch (IOException e) {
                        System.out.println("接收或读取数据失败");
                    }
                }
            });
            resceiveTh.start();
        }
    }
}