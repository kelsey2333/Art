/**
 * @Author wpzhang
 * @Date 2019/4/12
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @program: Wpzhang
 * @description: 中部面板
 * @author: wpzhang
 * @create: 2019-04-12 14:13
 **/
public class CenterPanel extends JSplitPane {

    /*
    中部面板成员变量 必须设置为静态，仅此一处
     */
    private static JScrollPane leftPanel;//左部面板
    private static JScrollPane rightPanel;//右部面板
    /*
    中部组件成员变量
     */
    private static JTextArea contentArea;//内容显示区
    private static JList userList;//用户列表
    private static DefaultListModel listModel;//存放用户信息，可以在userList中显示

    //初始化成员面板和组件变量
    static {
        /*
        必须按照顺序添加
         */
        listModel = new DefaultListModel();
        userList = new JList(listModel);

        //初始化文本区域
        contentArea = new JTextArea();

        //初始化左右面板，将文本区域和list模板加入到面板
        leftPanel = new JScrollPane(contentArea);
        rightPanel = new JScrollPane(userList);



        //设置左右边框
        leftPanel.setBorder(new TitledBorder("cotent area"));
        rightPanel.setBorder(new TitledBorder("user list"));
    }

    //将左右面板添加到中部面板上
    public CenterPanel() {
        super(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        setDividerLocation(450);
    }

    public static JScrollPane getLeftPanel() {
        return leftPanel;
    }

    public static void setLeftPanel(JScrollPane leftPanel) {
        CenterPanel.leftPanel = leftPanel;
    }

    public static JScrollPane getRightPanel() {
        return rightPanel;
    }

    public static void setRightPanel(JScrollPane rightPanel) {
        CenterPanel.rightPanel = rightPanel;
    }

    public static JTextArea getContentArea() {
        return contentArea;
    }

    public static void setContentArea(JTextArea contentArea) {
        CenterPanel.contentArea = contentArea;
    }

    public static JList getUserList() {
        return userList;
    }

    public static void setUserList(JList userList) {
        CenterPanel.userList = userList;
    }

    public static DefaultListModel getListModel() {
        return listModel;
    }

    public static void setListModel(DefaultListModel listModel) {
        CenterPanel.listModel = listModel;
    }
}