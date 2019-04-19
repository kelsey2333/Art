/**
 * @Author wpzhang
 * @Date 2019/4/17
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom.chatroom;

import com.wpzhang.javase2.day06.chatroom.chatroomDemo.NoticePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @program: Wpzhang
 * @description: 登入窗口
 * @author: wpzhang
 * @create: 2019-04-17 19:11
 **/
public class LoginFrame extends JFrame {
    /*
    保存各成员变量（窗体组件）
     */
    private String ip;
    private int port;

    private String nickname;
    private Socket clientSocket;

    public ClientTopPanel top;
    public NoticePanel notice;

    /*
     构造器
     */

    public LoginFrame() {
        initFrame();
        initConponent();
        connBtnAction();
    }

    /**
     * @return
     * @Param
     * @description 初始化组件信息
     * @date 2019/4/18 23:38
     */

    private void initConponent() {
        top = new ClientTopPanel();
        //将各面板添加到窗体上下部分
        notice = new NoticePanel();
        add(top, "North");
        add(notice, "South");
    }

    /**
     * @return
     * @Param
     * @description 初始化窗体信息
     * @date 2019/4/18 16:44
     */

    private void initFrame() {
        this.setTitle("ClientLogin");
        this.setSize(600, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * @return
     * @Param
     * @description 添加连接按钮的监听响应事件
     * @date 2019/4/12 17:44
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
                getIpInfo();
                //2、获取端口
                getPortInfo();
                //3、获取昵称
                getNickInfo();
                //保存clientSocket对象
                creatClientSocket();
                //建立连接成功后立即向服务器端发送nickname
                try {
                    sendNickName();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                dispose(); // 销毁当前窗体
                new Client(clientSocket);
            }
        });
    }

    /**
     * @Param
     * @description 发送昵称
     * @date 2019/4/18 23:39
     * @return
     */

    private void sendNickName() throws IOException {
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        pw.println(nickname);
    }

    /**
     * @Param
     * @description 构造信息提示方法
     * @date 2019/4/18 23:40
     * @return
     */

    private String buildMsgNotice(String notice) {
        StringBuilder sb = new StringBuilder();
        sb.append("[提示信息]:").append(notice).append("\n");
        return sb.toString();
    }

    /**
     * @Param
     * @description 创建Socket对象，建立连接
     * @date 2019/4/18 23:40
     * @return
     */

    private void creatClientSocket() {
        try {
            clientSocket = new Socket(ip, port);
        } catch (IOException e) {
            NoticePanel.getNoticeArea().append(buildMsgNotice("连接服务器失败！"));
        }
    }

    /**
     * @return
     * @Param
     * @description 获取昵称信息
     * @date 2019/4/17 13:54
     */

    private void getNickInfo() {
        nickname = top.getNickNameText().getText();
        if (checkname(nickname) == false) {
            NoticePanel.getNoticeArea().append("昵称格式错误\n");
        }
    }

    /**
     * @return
     * @Param
     * @description 获取端口信息
     * @date 2019/4/17 13:52
     */

    private void getPortInfo() {
        CenterPanel.getContentArea().removeAll();
        String str = top.getPortText().getText();
        if (checkPort(str) == false) {
            NoticePanel.getNoticeArea().append("端口格式错误\n");
        }
        port = Integer.valueOf(str);
    }

    /**
     * @return
     * @Param
     * @description 获取ip信息
     * @date 2019/4/17 13:51
     */

    private void getIpInfo() {
        ip = top.getIpText().getText();
        if (checkIp(ip) == false) {
            NoticePanel.getNoticeArea().append("ip格式错误\n");
            return;
        }
    }

    /**
     * @return
     * @Param
     * @description 正则检验各数据
     * @date 2019/4/15 6:04
     */
    /*
    正则校验ip
    分成几部： 200—255；100-199；10-99；0-9；
     */
    public boolean checkIp(String ip) {
        String ipNum = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."

                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (ip != null && (ip.matches(ipNum) || ip.matches("localhost"))) {
            return true;
        } else {
            return false;
        }
    }
    /*
    正则检验端口
    -分成几部： 60000-65535；10000-59999；1000-9999；100-999；10-99；0-9；
     */

    public boolean checkPort(String port) {
        String portNum = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
        if (port != null && port.matches(portNum)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    正则校验name
    要求:用户名必须是2-5位之间的字母、下划线、@、
     */

    public boolean checkname(String name) {
        String namePattern = "[A-Za-z|0-9]{2,5}";
        if (name != null && name.matches(namePattern)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return
     * @Param
     * @description 程序执行入口
     * @date 2019/4/18 16:51
     */

    public static void main(String[] args) {
        new LoginFrame();
        NoticePanel.getNoticeArea().append("欢迎你来聊天，请输入你的ip、port、nickname!\n");
    }
}