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
 * @description: 服务端
 * @author: wpzhang
 * @create: 2019-04-10 16:29
 **/
public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
     /*
     1、创建ServerSocket对象，端口设置为8888
     2、监听8888端口，是否有客户端建立连接的到来：accept方法
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
        br.readLine();
//        System.out.println("====");
    }
}