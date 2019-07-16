/**
 * @Author wpzhang
 * @Date 2019/4/17
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;


import javax.swing.*;
import java.awt.*;
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
    private JLabel pnText;
    private JLabel pwdText;
    private JTextField pnField;
    private JTextField pwdField;
    private JButton logBtn;
    private JButton regBtn;
    private JLabel mainPanel;
    private ImageIcon background;


    public LoginFrame(){
        //创建字体对象（微软雅黑，加粗，大小）
        Font font  = new Font("微软雅黑",Font.BOLD,32);
        //初始化窗体组件：手机号，登录密码
        pnText = new JLabel("手机号");
        pnText.setFont(font);
        pnText.setBounds(50,50,150,50);

        pwdText = new JLabel("登录密码");
        pwdText.setFont(font);
        pwdText.setBounds(50,150,150,50);

        //手机号文本域，登录密码文本域
        pnField = new JTextField();
        pnField.setBounds(200,50,150,50);
        pwdField = new JTextField();
        pwdField.setBounds(200,150,150,50);


        //登录注册按钮
        logBtn = new JButton("登录");
        logBtn.setBounds(250,300,100,50);
        logBtn.setBackground(Color.getHSBColor(220,113,235));
        regBtn = new JButton("注册");
        regBtn.setBounds(130,300,100,50);
        regBtn.setBackground(Color.getHSBColor(234,113,235));


        background = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Wpzhang\\resources\\登录背景图.jpg");// 背景图片


        //初始化主面板，将各组件添加到主面板上
        mainPanel = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        mainPanel.setBounds(0, 0, background.getIconWidth(),
                background.getIconHeight());

        mainPanel.add(pnText);
        mainPanel.add(pwdText);
        mainPanel.add(pnField);
        mainPanel.add(pwdField);
        mainPanel.add(logBtn);
        mainPanel.add(regBtn);


        //将主面板嵌到窗体上
        this.add(mainPanel);


        //初始化窗体
        this.setTitle("登录界面");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //添加按钮响应事件
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                new RegisterFrame();
            }
        });

    }
    public static void main(String[] args) {
        new LoginFrame();
    }
}