/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom.chatroom;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 服务器顶部面板
 * @author: wpzhang
 * @create: 2019-04-12 16:19
 **/
public class ServerTopPanel extends TopPanel {
    //初始化顶端面板成员变量
    public ServerTopPanel(){
        super();
        port = new JLabel("port");
        portText = new JTextField();

        connBotton = new JButton("start");
        disconnButton = new JButton("stop");


        //设置组件布局
        setLayout(new GridLayout(1,4));
        //添加到面板上
        add(port);
        add(portText);
        add(connBotton);
        add(disconnButton);
        //设置边界属性
        setBorder(new TitledBorder("Configeration"));

    }
}