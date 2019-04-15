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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: Wpzhang
 * @description: 服务器端
 * @author: wpzhang
 * @create: 2019-04-12 16:18
 **/
public class Server extends JFrame {
    Map<String, Socket> clients = new HashMap<String, Socket>();
    /*
    服务端窗体组件成员变量
     */
    private ServerTopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;
    private static final int ONLINE_USERS = 1;

    /*
    服务器端面板信息连接组件
     */
    private int port;
    private ServerSocket server;
    private BufferedReader br;
    private String nickname;
    private String nameOfUser;

    /**
     * @return void
     * @Param
     * @description 初始化组件成员变量
     * @date 2019/4/12 16:49
     */

    private void initComponent() {
        top = new ServerTopPanel();
        center = new CenterPanel();
        bottom = new BottomPanel();
        add(top, "North");
        add(center, "Center");
        add(bottom, "South");
    }

    /**
     * @return
     * @Param
     * @description 初始化窗体信息
     * @date 2019/4/12 16:49
     */

    private void initFrameConfig() {
        this.setTitle("server");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public Server() {
        initComponent();
        initFrameConfig();
        addBtnsAction();
    }

    private void addBtnsAction() {
        starBtnAction();
    }

    private void starBtnAction() {
        JButton ConnBtn = top.getConnBotton();
        ConnBtn.addActionListener(new ActionListener() {
            /*
            给start添加了连接点击响应，当点击了该按钮就执行actionPerformed任务
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取端口号
                String str = top.getPortText().getText();
                checkPort(str);
                port = Integer.valueOf(str);
                //创建Socket对象
                try {
                    //将建立好的服务器端保存起来
                    server = new ServerSocket(port);
                } catch (IOException e1) {
                    CenterPanel.getContentArea().append(buildMsgNotice("服务器启动失败！"));
                }
                CenterPanel.getContentArea().append(buildMsgNotice("服务器启动成功!"));
                  /*
                    循环监听（为了多个客户端都可以连接），建立连接，
                    且必须创建监听线程（若不创建，程序就会被阻塞在accept前）
                     */
                Thread acceptTh = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        /*
                        循环监听
                         */
                        while (true) {
                            try {
                                Socket client = server.accept();
                                //监听到客户端，建立连接成功后立即接受用户即刻发送过来的昵称(循环读取)
                                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                                nickname = br.readLine();
                                //接收到的昵称保存到clients集合中
                                clients.put(nickname, client);
                                //将客户端用户登录信息显示到内容显示区域
                                CenterPanel.getContentArea().append(buildMsgNotice(nickname + "已经登录服务器！"));

                                //将的登录成功的用户输出到登录用户列表区
                                CenterPanel.getListModel().addElement(nickname);

                                //获取到用户名
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < CenterPanel.getListModel().getSize(); i++) {
                                    //get()方法中返回的elementDate是一个Object[],所以要强制转换为String类型
                                    nameOfUser = (String) CenterPanel.getListModel().get(i);
                                    sb.append(nameOfUser).append(",");
                                }
                                System.out.println(sb.toString());

                                /*
                                将所有的在线用户广播给客户端
                                    -1、以一种协议发送给客户端
                                    -2、用户接收该协议并解析(客户端工作)
                                    -3、将解析出来的在线用户输出到用户列表区域（客户端工作）
                                 */

                                //1-1 以一种协议1@server:client1(client2)(client3)
                                String sendMsg = buildServerSendMsg(ONLINE_USERS, "server", sb.toString());
                                /*
                                 1-2 遍历客户端，将协议发送给客户端  获取输出流, 向该客户端发送登录用户信息
                                    （写出去的时候是不需要线程的，因为写出去的时候没有线程争抢）
                                 */
                                Set<Map.Entry<String, Socket>> entrySet = clients.entrySet();

                                for (Map.Entry<String, Socket> entry : entrySet) {
                                    //获取Socket对象cli
                                    Socket cli = entry.getValue();
                                    PrintWriter clipw = new PrintWriter(cli.getOutputStream(), true);
                                    clipw.println(sendMsg);
                                }
                               //循环接收客户端发送过来的信息
                                Thread receiveTh = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String receiveMsg = br.readLine();
                                            CenterPanel.getContentArea().append(buildReceiveNoticeMsg(nickname, receiveMsg));
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                });
                                receiveTh.start();

                            } catch (IOException e1) {
                                CenterPanel.getContentArea().append(buildMsgNotice("客户端建立连接失败！"));
                            }
                            CenterPanel.getContentArea().append(buildMsgNotice("客户端建立连接成功！"));
                        }
                    }
                });
                acceptTh.start();
            }

        });

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


    /**
     * @return
     * @Param
     * @description 构造接收提示格式方法
     * @date 2019/4/13 15:21
     */
    private String buildReceiveNoticeMsg(String nickname, String receiveMsg) {
        StringBuilder sb = new StringBuilder();
        sb.append(nickname).append("对我说：").append("\n").append("\t").append(receiveMsg);
        return sb.toString();
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
     * @return
     * @Param
     * @description 构造“将用户信息广播给客户端”的发送协议
     * @date 2019/4/13 11:33
     */
    public String buildServerSendMsg(Integer note, String nameOfSender, String nameOfReceiver) {
        StringBuilder sb = new StringBuilder();
        sb.append(note).append("@").append(nameOfSender).append(":").append(nameOfReceiver);
        return nameOfReceiver;
    }


    public ServerTopPanel getTop() {
        return top;
    }

    public void setTop(ServerTopPanel top) {
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
        new Server();
    }

}