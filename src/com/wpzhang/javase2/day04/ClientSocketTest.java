/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 客户端 TODO
 * @author: wpzhang
 * @create: 2019-04-10 16:26
 **/
public class ClientSocketTest {
    public static void main(String[] args) throws IOException {
       /*
        1、创建服务端的端口号和ip地址
        2、创建Socket对象，与服务器建立连接。若服务器没有启动，参数填写错误
          都会造成建立连接失败
        3、向服务器端发送数据
        4、发送hello
      */
//        1、创建服务端的端口号和ip地址

//        2、创建Socket对象，与服务器建立连接。若服务器没有启动，参数填写错误
        Socket client = new Socket("localhost",8888);
//        3、向服务器端发送数据
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(os),true);
//        os.write("hello".getBytes());
        Scanner scan  = new Scanner(System.in);

        while (true){
            System.out.println("请输入数据：");
            String msg = scan.next();
            if (msg.equals( "exit")){
               break;
            }
            pw.println(msg);
        }
        //关闭socket  同时关闭所有io流
        client.close();
    }
}