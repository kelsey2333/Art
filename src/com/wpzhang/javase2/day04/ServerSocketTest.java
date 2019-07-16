/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Wpzhang
 * @description: 服务端  TODO 同时阻塞，多个客户端同时建立连接，同时读取数据吗
 * @author: wpzhang
 * @create: 2019-04-10 16:29
 **/
public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
     /*
     1、创建ServerSocket对象，端口设置为8888
     2、监听8888端口，是否有客户端建立连接的到来：accept方法:阻塞方法，直到客户端请求的到来，才会
     建立连接成功，并且返回当前与服务端建立连接的Socket对象
     3、建立连接成功之后，接收数据
      */
//        1、创建ServerSocket对象，端口设置为8888
        ServerSocket serve = new ServerSocket(8888);
//        2、监听8888端口，是否有客户端建立连接的到来：accept方法
        Socket client = serve.accept();
//        3、建立连接成功之后，接收数据
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();

        //模拟接收用户输入的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        /*
        读写都是阻塞方法：在没读到任何内容时会一直阻塞在该代码前
        ，为了不发生阻塞（即使不读取任何内容也能让其他客户端连接到），要让读取放到接收线程中。
        这样读取就是单独的一个。先建立连接，建立连接后，执行线程的start，线程就绪，各线程抢时间片
         */
        br.readLine();
//        System.out.println("====");
    }
}