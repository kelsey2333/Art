/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.chatroomStandard;

import javax.swing.*;

/**
 * @program: Wpzhang
 * @description: 顶部面板
 * @author: wpzhang
 * @create: 2019-04-12 14:12
 **/
public class TopPanel extends JPanel {
    public TopPanel() {
    }

    //注解：父类面板中共有的属性
    /*
    父类面板组件成员变量
     */
    protected JLabel port;//显示port
    protected JTextField portText;//port输入框
    protected JButton connBotton;//连接按钮
    protected JButton disconnButton;//断开按钮

    public JLabel getPort() {
        return port;
    }

    public void setPort(JLabel port) {
        this.port = port;
    }

    public JTextField getPortText() {
        return portText;
    }

    public void setPortText(JTextField portText) {
        this.portText = portText;
    }

    public JButton getConnBotton() {
        return connBotton;
    }

    public void setConnBotton(JButton connBotton) {
        this.connBotton = connBotton;
    }

    public JButton getDisconnButton() {
        return disconnButton;
    }

    public void setDisconnButton(JButton disconnButton) {
        this.disconnButton = disconnButton;
    }
}