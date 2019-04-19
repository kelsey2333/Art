/**
 * @Author wpzhang
 * @Date 2019/4/18
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom.chatroom;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: Wpzhang
 * @description: 提示面板
 * @author: wpzhang
 * @create: 2019-04-18 15:46
 **/
public class NoticePanel extends JPanel {

    private  static JTextArea noticeArea;//内容显示区
    public NoticePanel(){
        noticeArea = new JTextArea();
        noticeArea.setRows(3);
        //设置面板排列
        setLayout(new GridLayout());
        //添加提示区到面板上
        add(noticeArea);
        //设置面板边界属性
        setBorder(new TitledBorder("notice area"));
    }

    public static JTextArea getNoticeArea() {
        return noticeArea;
    }

    public static void setNoticeArea(JTextArea noticeArea) {
        NoticePanel.noticeArea = noticeArea;
    }
}