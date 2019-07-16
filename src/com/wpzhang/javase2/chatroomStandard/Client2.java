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
import java.net.Socket;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-12 13:59
 **/
public class Client2 extends JFrame {
    public Client2() {
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
    private JTextField ipText;//显示id输入框

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


    private static final String CLIENT_TO_CLIENT = "clientToClient";
    private static final String ONLINE_USERS = "onlineusers";
    private static final String PRIVATE_TALK = "privateTalk";
    private static final String GROUP_TALK = "groupTalk";

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
        cancelBtnAction();
    }
    /**
     * @Param
     * @description 清空聊天记录
     * @date 2019/4/17 14:16
     * @return
     */

    private void cancelBtnAction(){
        JButton cancelBtn = bottom.getCancelBtn();
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CenterPanel.getContentArea().remove(9);
//                CenterPanel.getContentArea().setText("");
            }
        });

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
                //判断是否选中在线用户
                System.out.println(nickName);
                if (nickName != null) {
                    sendText = buildClientSendMsg(CLIENT_TO_CLIENT, nickName, sendText);
                    //4、获取Socket的输出流，发送数据
                    writer.println(sendText);
                   CenterPanel.getContentArea().append("我对"+nickName+"说：\n");
                }else {
                    //群聊
                    sendText = buildClientSendMsg(GROUP_TALK,"全体成员",sendText);
                    writer.println(sendText);
                }

            }
        });

    }

    /**
     * @return
     * @Param
     * @description 构造发送提示信息的方法
     * @date 2019/4/14 10:29
     */
    public String buildSendNoticeMsg(String toName, String sendText) {
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

    private String buildClientSendMsg(String type, String nickname, String sendText) {
        sb = new StringBuilder();
        sb.append(type).append("@").append(nickname).append(":").append(sendText);
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
                //1、获取ip信息
                getIpInfo();
                //2、取端口信息
                getPortInfo();
                //3、获取昵称信息
                getNickInfo();
                //根据ip,port创建clientSocket对象并保存
                creatSocket(ip,port);
                //建立连接成功后立即向服务器端发送nickname
                try {
                    sendNickName();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //1、接收服务器端发来的协议
                creatReceiveThread();
            }
        });

    }

    private void sendNickName() throws IOException {
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writer.println(nickname);
    }

    private Socket  creatSocket(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
        } catch (IOException e) {
            CenterPanel.getContentArea().append(buildMsgNotice("连接服务器失败！"));
        }
            CenterPanel.getContentArea().append(buildMsgNotice("连接服务器成功！"));
            return clientSocket;
    }

    /**
     * @Param
     * @description 接收服务端发送过来的协议
     * @date 2019/4/17 13:57
     * @return
     */

    private void creatReceiveThread() {
        Thread receiveTh = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        //读取服务端发送过来的数据

                        String receiveMsg = reader.readLine();
                        System.out.println(receiveMsg);
                        //解析方法：parsetype  parsenickname  parsecontent
                        String type = parsetype(receiveMsg);
                        String name = parsename(receiveMsg);
                        String content = parsecontent(receiveMsg);

                        //根据不同的信息类型（协议类型）进行不同的处理
                        switch (type) {
                            case ONLINE_USERS:
                                //清空列表区
                                CenterPanel.getListModel().clear();
                                String[] onlineUsers = content.split(",");
                                for (String onlineUser : onlineUsers) {
                                    CenterPanel.getListModel().addElement(onlineUser);
                                    CenterPanel.getContentArea().append(onlineUser+ "上线了!当前在线人数："+onlineUsers.length);
                                }
                                break;
                            case PRIVATE_TALK:
                                        /*
                                        接收服务器端发送的私聊信息
                                        将私聊信息显示在内容显示区
                                         */
                                CenterPanel.getContentArea().append(buildReceivaNoticeMsg(name, content));
                                break;
                            case GROUP_TALK:
                                //我自己（是客户端发送过来的自己）对全体成员说
                                CenterPanel.getContentArea().append(name+"对全体人员说：\n"+content+"\n");
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
     * @description 获取昵称信息
     * @date 2019/4/17 13:54
     * @return
     */

    private void getNickInfo() {
        nickname = top.getNickNameText().getText();
        if (checkname(nickname)==false){
            CenterPanel.getContentArea().append("昵称格式错误！");
        }
    }


    /**
     * @Param
     * @description 获取ip信息
     * @date 2019/4/17 13:51
     * @return
     */

    private void getIpInfo() {
        ip = top.getIpText().getText();
//                ip = "localhost";
        if (checkIp(ip)==false){
            CenterPanel.getContentArea().append("ip格式错误");
            return;
        }

    }
    /**
     * @Param
     * @description 获取端口信息
     * @date 2019/4/17 13:52
     * @return
     */

    private void getPortInfo() {
        CenterPanel.getContentArea().removeAll();
        String str = top.getPortText().getText();
        port = Integer.valueOf(str);
        if ( checkPort(str)==false){
            CenterPanel.getContentArea().append("端口格式错误！");
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
        if (ip != null &&(ip.matches(ipNum)||ip.matches("localhost"))) {
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
     * @description 构造接收服务器端的提示信息
     * @date 2019/4/15 11:28
     */
    public String buildReceivaNoticeMsg(String toName, String receiveText) {
        StringBuilder sb = new StringBuilder();
        sb.append(toName).append("对我说").append("\n").append("\t").append(receiveText).append("\n");
        return sb.toString();
    }

    /**
     * @return type
     * @Param
     * @description 解析type
     * @date 2019/4/13 14:03
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
        this.setTitle("client2");
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

    public String getname() {
        return nickname;
    }

    public void setname(String name) {
        this.nickname = name;
    }


    /**
     * @Param
     * @description 程序执行入口
     * @date 2019/4/17 15:00
     * @return
     */

    public static void main(String[] args) {
        new Client2();
        CenterPanel.getContentArea().append("欢迎你来聊天，请输入你的ip、port、nickname!\n");
    }

}