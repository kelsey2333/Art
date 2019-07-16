/**
 * @Author wpzhang
 * @Date 2019/4/11
 * @Description
 */
package com.wpzhang.javase2.day05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description: 客户端
 * @author: wpzhang
 * @create: 2019-04-11 14:07
 **/
public class Client1 {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket client = new Socket("localhost", 8888);
        System.out.println("客户端创建成功！");

        //建立连接成功之后马上向服务器端发送数据
        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();

        PrintWriter pw = new PrintWriter(os, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        Thread receiveTh = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String receive = br.readLine();
                        System.out.println("接收到服务器返回的数据：" + receive);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        receiveTh.start();

       //重复发送数据
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要传输的信息");
            String msg = scan.next();
            if ("exit".equals(msg)) {
                break;
            }
            pw.println(msg);
        }
        client.close();
    }
}