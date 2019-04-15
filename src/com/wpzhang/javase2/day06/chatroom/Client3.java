/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-12 13:59
 **/
public class Client3 extends JFrame {
    public Client3() {
        initComponent();//初始化组件
        initFrameConfig();//初始化窗体配置信息
        addBtnsAction();//添加按钮事件
    }

    /*
    上中下面板成员变量（窗体组件）
     */
    private ClientTopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;

    /*
   客户端面板连接信息组件
   */
    private  String ip;
    private int port;
    private String nickname;
    private Socket clientSocket;
    private PrintWriter writer;


    /**
     * @return void
     * @Param
     * @description 初始化窗体组件
     * @date 2019/4/12 14:15
     */
    public void initComponent() {
        top = new ClientTopPanel();
        center = new CenterPanel();
        bottom = new BottomPanel();
        //将各面板添加到窗体上中下部分
        add(top, "North");
        add(center, "Center");
        add(bottom, "South");
    }

    /**
     * @Param
     * @description 添加按钮事件
     * @date 2019/4/12 17:43
     * @return  void
     */

    private void addBtnsAction() {
        connBtnAction();
    }
    /**
     * @Param
     * @description 添加连接按钮的监听响应事件
     * @date 2019/4/12 17:44
     * @return
     */

    private void connBtnAction() {
        //获取连接按钮对象
        JButton ConnBtn = top.getConnBotton();
        ConnBtn.addActionListener(new ActionListener() {
            /*
             ConnBtn添加了连接点击响应：当点击该按钮时就会执行actionPerformed方法
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取ip
                ip = top.getIpText().getText();
                //2、获取端口
                String str = top.getPortText().getText();
                port = Integer.valueOf(str);
                //3、获取昵称
                nickname = top.getNickNameText().getText();
                //根据ip,port创建Socket对象
                try {
                    //保存clientSocket对象
                    clientSocket = new Socket(ip,port);
                    //建立连接成功后立即向服务器端发送nickname
                    writer = new PrintWriter(clientSocket.getOutputStream(),true);
                    writer.println(nickname);
                } catch (IOException e1) {
                  CenterPanel.getContentArea().append( buildMsgNotice("连接服务器失败！"));
                }
                CenterPanel.getContentArea().append(buildMsgNotice("连接服务器成功"));
            }
        });

    }

    /**
     * @Param
     * @description 构造提示信息格式方法
     * @date 2019/4/13 9:40
     * @return  String
     */
    public String buildMsgNotice(String notice){
        StringBuilder sb = new StringBuilder();
        sb.append("[提示信息]:").append(notice).append("\n");
        return sb.toString();
    }



    /**
     * @return void
     * @Param
     * @description初始化窗体配置信息和程序执行入口
     * @date 2019/4/12 14:07
     */
    public void initFrameConfig() {
        this.setTitle("client3");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }


    public ClientTopPanel getTop() {
        return top;
    }

    public void setTop(ClientTopPanel top) {
        this.top = top;
    }

    public CenterPanel getCenter() {
        return center;
    }

    public void setCenter(CenterPanel center) {
        this.center = center;
    }

    public BottomPanel getBottom() {
        return bottom;
    }

    public void setBottom(BottomPanel bottom) {
        this.bottom = bottom;
    }

    public static void main(String[] args) {
        new Client3();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}