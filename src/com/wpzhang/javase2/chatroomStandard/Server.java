/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.chatroomStandard;


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

    private static final String  ONLINE_USERS = "onlineusers";
    private static final String CLIENT_TO_CLIENT = "clientToClient";
    private static final String PRIVATE_TALK = "privateTalk";
    private static final String GROUP_TALK = "groupTalk";

    /*
    服务器端面板信息连接组件
     */
    private int port;
    private ServerSocket server;
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

        top.getConnBotton().addActionListener(new ActionListener() {
            /*
            给start添加了连接点击响应，当点击了该按钮就执行actionPerformed任务
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取端口
                getPortInfo();
                //创建Socket对象
                creatServer();
                //创建监听线程，让该线程循环监听客户端的建立
                creatAcceptThread();
            }
        });

    }
    /**
     * @Param
     * @description 创建并启动监听线程
     * @date 2019/4/15 17:33
     * @return
     */

    private void creatAcceptThread() {
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
                        //创建客户端连接，并且保存客户端信息
                        String nickname = creatClientLink();
                        //广播在线用户列表
                        boardcastOnlineUsers();

                        //创建接收线程，循环接收当前建立客户端发送过来的数据
                        creatReceiveThread(nickname,clients.get(nickname));
                        //显示提示信息
                        CenterPanel.getContentArea().append(buildMsgNotice("客户端建立连接成功！"));
                    } catch (IOException e1) {
                        CenterPanel.getContentArea().append(buildMsgNotice("客户端建立连接失败！"));
                    }
                }
            }
        });
        acceptTh.start();
    }
    /**
     * @Param
     * @description 广播在线用户列表
     * @date 2019/4/15 17:31
     * @return
     */

    private void boardcastOnlineUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CenterPanel.getListModel().getSize(); i++) {
            nameOfUser = (String) CenterPanel.getListModel().get(i);
            sb.append(nameOfUser).append(",");
        }
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
    }
    /**
     * @Param
     * @description 建立连接，保存客户端信息，返回昵称
     * @date 2019/4/15 17:30
     * @return
     */

    private String creatClientLink() throws IOException {
        Socket client = server.accept();
        //监听到客户端，建立连接成功后立即接受用户即刻发送过来的昵称(循环读取)
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        nickname = br.readLine();
        //接收到的昵称保存到clients集合中
        clients.put(nickname, client);
        //将客户端用户登录信息显示到内容显示区域
        CenterPanel.getContentArea().append(buildMsgNotice(nickname + "已经登录服务器！当前在线人数："+clients.size()));

        //将的登录成功的用户输出到登录用户列表区
        CenterPanel.getListModel().addElement(nickname);
        return nickname;
    }
    /**
     * @Param
     * @description 创建监听线程，用来接收当前客户端发送过来的数据
     * @date 2019/4/15 17:34
     * @return
     */

    private void creatReceiveThread(String nickname,Socket clientSocket) {
        //循环接收客户端发送过来的信息
        Thread receiveTh = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String receiveMsg = br.readLine();
                        System.out.println("接收客户端发送过来的消息：" + receiveMsg);

                        //解析方法：parsetype  parsenickname  parsecontent
                        String type = parsetype(receiveMsg);
                        String name = parsename(receiveMsg);
                        String content = parsecontent(receiveMsg);

                        switch (type) {
                            case CLIENT_TO_CLIENT:
                                //1、获取客户端要私聊的用户组件
                                Socket clientSocket = clients.get(name);
                                //2、获取客户端输出流，输出信息
                                PrintWriter clientPw = new PrintWriter(clientSocket.getOutputStream(), true);
                                //3、构造发送协议，向用户发送数据
                                String sendMsg = buildServerSendMsg(PRIVATE_TALK, nickname, content);
                                System.out.println(sendMsg);
                                clientPw.println(sendMsg);
                                //提示到内容显示区域：xxx对xxx说：
                                CenterPanel.getContentArea().append(buildReceiveNoticeMsg(nickname, name, receiveMsg));
//                                System.out.println("xxx对xxx说");
                                break;
                            case GROUP_TALK:
                                // 遍历客户端, 广播在线用户消息
                                Set<Map.Entry<String, Socket>> entrySet = clients.entrySet();
                                for (Map.Entry<String, Socket> entry : entrySet) {
                                    // 获取客户端通信Socket对象
                                    Socket cli= entry.getValue();
                                    // 获取输出流, 向该客户端发送登录用户信息
                                    PrintWriter cliPw = new PrintWriter(cli.getOutputStream(), true);
                                    cliPw.println(buildServerSendMsg(GROUP_TALK,nickname,content));
                                }
                                CenterPanel.getContentArea().append(nickname + "对全体成员说:\n"+content+"\n");
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
    /**
     * @Param
     * @description 启动服务器
     * @date 2019/4/15 17:35
     * @return
     */

    private void creatServer() {
        try {
            //将建立好的服务器端保存起来
            server = new ServerSocket(port);
        } catch (IOException e1) {
            CenterPanel.getContentArea().append(buildMsgNotice("服务器启动失败！"));
        }
        CenterPanel.getContentArea().append(buildMsgNotice("服务器启动成功!"));
    }
    /**
     * @Param
     * @description 获取端口号
     * @date 2019/4/15 17:35
     * @return void
     */

    private void getPortInfo() {
        String str = top.getPortText().getText();
        port = Integer.valueOf(str);
        if ( checkPort(str)==false){
            CenterPanel.getContentArea().append("端口格式错误！");
        }
    }

     /**
      * @Param 分成几部： 60000-65535；10000-59999；1000-9999；100-999；10-99；0-9
      * @description 正则校验端口
      * @date 2019/4/17 13:48
      * @return
      */

    public boolean checkPort(String port){
        String portNum = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
        if (port != null && port.matches(portNum)){
            return true;
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


    private String buildReceiveNoticeMsg(String fromName,String toName, String receiveMsg) {
        StringBuilder sb = new StringBuilder();
        sb.append(fromName).append("对"+toName+"说：").append("\n").append("\t").append(receiveMsg).append("\n");
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
    public String buildServerSendMsg(String note, String nameOfSender, String nameOfReceiver) {
        StringBuilder sb = new StringBuilder();
        sb.append(note).append("@").append(nameOfSender).append(":").append(nameOfReceiver);
        return sb.toString();
    }
    /**
     * @Param
     * @description 解析type
     * @date 2019/4/13 14:03
     * @return type
     */


    public String parsetype(String str) {
        int index1 = str.indexOf("@");
        System.out.println(index1);
        System.out.println(str);
        return str.substring(0, index1);
    }

    /**
     * @return name
     * @Param
     * @description 解析name
     * @date 2019/4/13 14:07
     */
    public String parsename(String str) {
        int index1 = str.indexOf("@");
        int index2 = str.indexOf(":");
        String name = str.substring(index1 + 1, index2);
        return name;
    }

    /**
     * @return content
     * @Param
     * @description 解析content
     * @date 2019/4/13 14:15
     */
    public String parsecontent(String str) {
        int index2 = str.indexOf(":");
        String content = str.substring(index2 + 1);
        return content;
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