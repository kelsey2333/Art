/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

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
 * @description:
 * @author: wpzhang
 * @create: 2019-04-12 13:59
 **/
public class Client extends JFrame {
    public Client() {
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
    private String ip;
    private int port;
    private String nickname;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;
    private StringBuilder sb;
    private static final Integer CLIENT_TO_CLIENT = 1;

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


    private void addBtnsAction() {
        connBtnAction();
        sendBtnAction();
    }

    /**
     * @return
     * @Param
     * @description 添加发送按钮响应事件
     * @date 2019/4/13 15:52
     */

    private void sendBtnAction() {
        //获取连接按钮对象
        JButton StarBtn = bottom.getSendBtn();
        StarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //1、获取发送区输入框中的内容
                String sendText = bottom.getSendText().getText();
                //2、获取选中要发送的用户昵称
                String nickName = (String) CenterPanel.getUserList().getSelectedValue();
                //3、构造消息发送协议
                String text = buildClientSendMsg(CLIENT_TO_CLIENT, nickName, sendText);
                //4、获取Socket的输出流，发送数据
                writer.println(sendText);
//                5、将发送的内容显示在内容显示区中
                CenterPanel.getContentArea().append(buildSendNoticeMsg("Server",sendText));
            }
        });

    }
    /**
     * @Param
     * @description 构造发送提示信息的方法
     * @date 2019/4/14 10:29
     * @return
     */
    public String  buildSendNoticeMsg(String toName,String sendText){
        StringBuilder sb = new StringBuilder();
        sb.append(nickname).append("对").append(toName).append(":")
                .append("\n").append("\t").append(sendText).append("\n");
        return sb.toString();
    }


    /**
     * @return
     * @Param
     * @description 构造客户之间私信的协议
     * @date 2019/4/13 16:18
     */

    private String buildClientSendMsg(Integer note, String nickname, String sendText) {
        sb = new StringBuilder();
        sb.append(note).append("@").append(nickname).append(":").append(sendText);
        return sb.toString();
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
                ip = top.getIpText().getText();
                checkIp(ip);
                //2、获取端口
                String str = top.getPortText().getText();
                checkPort(str);
                port = Integer.valueOf(str);

                //3、获取昵称
                nickname = top.getNickNameText().getText();
                checkPort(nickname);
                //根据ip,port创建Socket对象
                try {
                    //保存clientSocket对象
                    clientSocket = new Socket(ip, port);
                    //建立连接成功后立即向服务器端发送nickname
                    writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println(nickname);
                } catch (IOException e1) {
                    CenterPanel.getContentArea().append(buildMsgNotice("连接服务器失败！"));
                }
                CenterPanel.getContentArea().append(buildMsgNotice("连接服务器成功"));
                    /*
                     -1、接收服务器端发来的协议
                     -2、解析协议
                     -3、将解析出来的nameOfReceiver输出到用户列表上
                     */
                //1、接收服务器端发来的协议
                Thread receiveTh = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                String receiveMsg = reader.readLine();
                                //解析方法：parseNote  parsenickname  parseNameOfReceiver
                                Integer note = parseNote(receiveMsg);
                                String nickname = parsenickname(receiveMsg);
                                String nameOfReceiver = parseNameOfReceiver(receiveMsg);

                                //根据不同的信息类型（协议类型）进行不同的处理
                                switch (note) {
                                    case 1:
                                        String[] onlineUsers = nameOfReceiver.split(",");
                                        for (String onlineUser : onlineUsers) {
                                            CenterPanel.getListModel().addElement(onlineUser);
                                        }
                                        break;
                                }
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
                receiveTh.start();
            }
        });

    }

    /**
     * @Param
     * @description 正则检验各数据
     * @date 2019/4/15 6:04
     * @return
     */
    /*
    正则校验ip
    分成几部： 200—255；100-199；10-99；0-9；
     */
    public boolean checkIp(String ip){
        String ipNum = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (ip != null && ip.matches(ipNum)){
            return true;
        }else{
            return false;
        }
    }
    /*
    正则检验端口
    -分成几部： 60000-65535；10000-59999；1000-9999；100-999；10-99；0-9；
     */

    public boolean checkPort(String port){
       String portNum =  "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
       if (port != null && port.matches(portNum)){
           return  true;
       }else{
           return false;
       }
    }
    
    /*
    正则校验nickname
    要求:用户名必须是6-10位之间的字母、下划线、@、
     */
    public boolean checkNickname(String nickname){
        String nicknamePattern = "[A-Za-z_@.]{6,10}";
        if (nickname != null && nickname.matches(nicknamePattern)){
            return true;
        }else{
            return false;
        }
    }


    /**
     * @Param
     * @description 解析note
     * @date 2019/4/13 14:03
     * @return note
     */
    private int index1;
    private int index2;

    public Integer parseNote(String str) {
        index1 = str.indexOf("@");
        Integer note = Integer.valueOf(str.substring(0, index1));
        return note;
    }

    /**
     * @return nickname
     * @Param
     * @description 解析nickname
     * @date 2019/4/13 14:07
     */
    public String parsenickname(String str) {
        index2 = str.indexOf(":");
        String nickname = str.substring(index1 + 1, index2);
        return nickname;
    }

    /**
     * @return nameOfReceiver
     * @Param
     * @description 解析nameOfReceiver
     * @date 2019/4/13 14:15
     */
    public String parseNameOfReceiver(String str) {
        String nameOfReceiver = str.substring(index2 + 1);
        return nameOfReceiver;
    }


    /**
     * @return String
     * @Param
     * @description 构造提示信息格式方法
     * @date 2019/4/13 9:40
     */
    public String buildMsgNotice(String notice) {
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
        this.setTitle("client");
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
        new Client();
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