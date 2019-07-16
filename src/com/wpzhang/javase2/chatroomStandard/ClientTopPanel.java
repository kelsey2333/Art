/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.chatroomStandard;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 客户端顶部面板
 * @author: wpzhang
 * @create: 2019-04-12 14:29
 **/
public class ClientTopPanel extends TopPanel {
    public ClientTopPanel() {
        super();
        //初始化客户端顶部面板组件
        ip = new JLabel("IP");
        ipText = new JTextField();

        port = new JLabel("port");
        portText = new JTextField();

        nickName = new JLabel("nickname");
        nickNameText = new JTextField();

        connBotton = new JButton("conn");
        disconnButton = new JButton("disconn");

        //将组件添加到面板上
        add(ip);
        add(ipText);

        add(port);
        add(portText);

        add(nickName);
        add(nickNameText);

        add(connBotton);
        add(disconnButton);

        //设置面板布局格式：XX行XX列
        setLayout(new GridLayout(1, 4));
        //设置面板边界属性
        setBorder(new TitledBorder("Configuration"));


    }

    private JLabel ip;//显示id
    private JTextField ipText;//显示id输入框

    private JLabel nickName;//显示昵称
    private JTextField nickNameText;//显示昵称输入框

    public JLabel getIp() {
        return ip;
    }

    public void setIp(JLabel ip) {
        this.ip = ip;
    }

    public JTextField getIpText() {
        return ipText;
    }

    public void setIpText(JTextField ipText) {
        this.ipText = ipText;
    }

    public JLabel getNickName() {
        return nickName;
    }

    public void setNickName(JLabel nickName) {
        this.nickName = nickName;
    }

    public JTextField getNickNameText() {
        return nickNameText;
    }

    public void setNickNameText(JTextField nickNameText) {
        this.nickNameText = nickNameText;
    }
}