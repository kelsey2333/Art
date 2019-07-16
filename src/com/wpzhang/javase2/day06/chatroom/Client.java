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
import java.util.*;

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
        creatReceiveThread();//接收服务端发送过来的协议
        addBtnsAction();//添加按钮事件
    }
    /*
    对构造器的重载：将LoginFrame中的初始化后的clientSocket传入到本类中
     */

    public Client(Socket clientSocket){
        this.clientSocket = clientSocket;
        initComponent();//初始化组件
        initFrameConfig();//初始化窗体配置信息
        addBtnsAction();//添加按钮事件
        creatReceiveThread();//接收服务端发送过来的协议
    }

    /*
    中下面板成员变量（窗体组件）
     */

    private CenterPanel center;
    private BottomPanel bottom;

    /*
   客户端面板连接信息组件及有关成员变量
   */
    Map<String ,Integer>clientWords = new HashMap<String,Integer>();
    private  String str;
    private Integer sentences = 0;
    private String ip;
    private int port;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;
    private StringBuilder sb;
    private String beforeLastButOne;
    private  String beforeLastButTwo;
    private int clickFrequency = 1;
    private  String cancelText;
    private String onlineUser;
    private String name;
    private String content;

    /*
    各协议类型
     */

    private static final String CLIENT_TO_CLIENT = "clientToClient";
    private static final String ONLINE_USERS = "onlineusers";
    private static final String PRIVATE_TALK = "privateTalk";
    private static final String GROUP_TALK = "groupTalk";
    private static final String CANCEL = "cancel";

    /**
     * @return void
     * @Param
     * @description 初始化窗体组件
     * @date 2019/4/12 14:15
     */

    public void initComponent() {
        center = new CenterPanel();
        bottom = new BottomPanel();
        //将各面板添加到窗体上中下部分
        add(center, "Center");
        add(bottom, "South");
    }

    /**
     * @Param
     * @description初始化窗体配置信息
     * @date 2019/4/12 14:07
     * @return void
     */

    public void initFrameConfig() {
        this.setTitle("client");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * @Param
     * @description 添加按钮响应
     * @date 2019/4/18 23:02
     * @return
     */

    private void addBtnsAction() {
        sendBtnAction();
        cancelBtnAction();
    }

    /**
     * @Param
     * @description 撤回按钮响应事件
     * @date 2019/4/17 14:16
     * @return
     */

    private void cancelBtnAction(){
        JButton cancelBtn = bottom.getCancelBtn();
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void  actionPerformed(ActionEvent e) {
                cancelText = buildClientSendMsg(CANCEL,"全体成员","撤回了一句话");
                writer.println(cancelText);
//                writer.close();
            }
        });
}

    /**
     * @Param
     * @description 添加发送按钮响应事件
     * @date 2019/4/18 23:05
     * @return
     */

    private void sendBtnAction() {
        //获取连接按钮对象
        JButton StarBtn = bottom.getSendBtn();
        StarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                Map<>
                //1、获取发送区输入框中的内容
                String sendText = bottom.getSendText().getText();
                //2、获取选中要发送的用户昵称
                String nickName = (String) CenterPanel.getUserList().getSelectedValue();
                //3、判断是否选中在线用户
                System.out.println(nickName);
                if (nickName != null) {
                    //私聊
                    String sendText2 = buildClientSendMsg(CLIENT_TO_CLIENT, nickName, sendText);
                    //4、获取Socket的输出流，发送数据
                    writer.println(sendText2);
                    String str = "我对"+nickName+"说：\n"+bottom.getSendText().getText()+"\n";
                    CenterPanel.getContentArea().append(str);
                    //每当我说了一句话我就把它保存在集合里
                    clientWords.put(str,++sentences);
                    Set<Map.Entry<String,Integer>>entrySet = clientWords.entrySet();
                    for (Map.Entry<String,Integer>entry:entrySet){
                        System.out.println(entry);
                    }
                }else {
                    //群聊
                    String sendText3 = buildClientSendMsg(GROUP_TALK,"全体成员",sendText);
                    writer.println(sendText3);
                }
            }
        });
    }

    /**
     * @Param
     * @description 创建接收线程
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
                        writer = new PrintWriter(clientSocket.getOutputStream(),true);
                        String receiveMsg = reader.readLine();
                        System.out.println(receiveMsg);
                        //解析方法：parsetype  parsenickname  parsecontent
                        String type = parsetype(receiveMsg);
                        name = parsename(receiveMsg);
                        content = parsecontent(receiveMsg);
                        //根据不同的信息类型（协议类型）进行不同的处理
                        switch (type) {
                            case ONLINE_USERS:
                                /*
                                将接收到的上线用户姓名添加到列表显示区
                                 */
                                //清空列表区
                                CenterPanel.getListModel().clear();
                                String[] onlineUsers = content.split(",");
                                //将增强for循环改成了迭代器循环，因为需要将onlineUser作为成员变量保存起来以便后期可能的使用
                                Collection<String> c = Arrays.asList(onlineUsers);
                                Iterator<String> it = c.iterator();
                                while(it.hasNext()){
                                    onlineUser = it.next();
                                    CenterPanel.getListModel().addElement(onlineUser);//将在线人显示到列表显示区
                                }
                                CenterPanel.getContentArea().append(onlineUser+ "上线了!当前在线人数："+onlineUsers.length+"\n");
                                break;
                            case PRIVATE_TALK:
                                /*
                                接收服务器端发送的私聊信息
                                将私聊信息显示在内容显示区
                                */
                                CenterPanel.getContentArea().append(buildReceivaNoticeMsg(name, content));
                                break;
                            case GROUP_TALK:
                                /*
                                接收服务器端发送过来的群聊信息
                                将群聊信息显示在列表显示区
                                 */
                                CenterPanel.getContentArea().append(name+"对全体人员说：\n"+content+"\n");
                                break;
                            case CANCEL:

                                System.out.println(clientWords.get(str));
                                CenterPanel.getContentArea().append(name + content + "\n");

//                                if (clickFrequency > 0){
//                                    String chatContent = CenterPanel.getContentArea().getText();
//                                    String beforeLast = chatContent.substring(0,chatContent.lastIndexOf("\n"));//最后\n前的内容
//                                    beforeLastButOne = beforeLast.substring(0,beforeLast.lastIndexOf("\n"));//倒数第二个\n前的内容
//                                    beforeLastButTwo = beforeLastButOne.substring(0,beforeLastButOne.lastIndexOf("\n"));//倒数第三个\n之前的内容
//                                    CenterPanel.getContentArea().setText(beforeLastButTwo+"\n");
//                                    CenterPanel.getContentArea().append(name + content + "\n");
//                                    clickFrequency--;
//                                }else{
//                                    CenterPanel.getContentArea().append("只能撤销一次哦！\n");
//                                }
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
     * @description 构造客户之间私信的协议
     * @date 2019/4/18 23:07
     * @return
     */

    private String buildClientSendMsg(String type, String nickname, String sendText) {
        sb = new StringBuilder();
        sb.append(type).append("@").append(nickname).append(":").append(sendText);
        return sb.toString();
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
     * @Param
     * @description 解析name
     * @date 2019/4/13 14:07
     * @return name
     */
    public String parsename(String str) {
        int index1 = str.indexOf("@");
        int index2 = str.indexOf(":");
        String name = str.substring(index1 + 1, index2);
        return name;
    }

    /**
     * @Param
     * @description 解析content
     * @date 2019/4/13 14:15
     * @return content
     */
    public String parsecontent(String str) {
        int index2 = str.indexOf(":");
        String content = str.substring(index2 + 1);
        return content;
    }

    /**
     * @Param
     * @description 构造提示信息格式方法
     * @date 2019/4/13 9:40
     * @return String
     */

    public String buildMsgNotice(String notice) {
        StringBuilder sb = new StringBuilder();
        sb.append("[提示信息]:").append(notice).append("\n");
        return sb.toString();
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

    /**
     * @Param
     * @description 程序执行入口
     * @date 2019/4/17 15:00
     * @return
     */

    public static void main(String[] args) {
        new Client();
    }
}