/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 底部面板
 * @author: wpzhang
 * @create: 2019-04-12 14:13
 **/
public class BottomPanel extends JPanel {
    /*
    底部面板组件成员变量
     */
    private  JTextField sendText;
    private  JButton sendBtn;

    //初始化底部面板组件
    public BottomPanel() {
        sendText = new JTextField();
        sendBtn = new JButton("send ");
        //设置面板布局 XX行XX列
        setLayout(new BorderLayout());
        //将组件添加到面板上：
        add(sendText, "Center");
        add(sendBtn, "East");

        //设置面板边界属性
        setBorder(new TitledBorder("send area"));
    }

    public JTextField getSendText() {
        return sendText;
    }

    public void setSendText(JTextField sendText) {
        this.sendText = sendText;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public void setSendBtn(JButton sendBtn) {
        this.sendBtn = sendBtn;
    }
}