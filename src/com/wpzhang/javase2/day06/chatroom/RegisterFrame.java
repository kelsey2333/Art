/**
 * @Author wpzhang
 * @Date 2019/4/30
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

import com.wpzhang.jdbc.day01.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * @program: Wpzhang
 * @description: 注册窗体
 * @author: wpzhang
 * @create: 2019-04-30 15:08
 **/
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        //初始化组件
        initComponents();
        //初始化窗体
        initFrame();
        //添加按钮响应
        addBtnAction();
    }


    private JLabel pnText;
    private JLabel pwdText;

    private JLabel nnText;
    private JTextField pnField;
    private JTextField pwdField;

    private JTextField nnField;
    private JButton regBtn;

    private JButton backBtn;
    private ImageIcon background;
    private JLabel mainPanel;
    private JLabel pnTips;

        /**
         * @Param
         * @description 初始化组件
         * @date 2019/5/12 23:07
         * @return
         */
        private  void initComponents(){
            Font font = new Font("微软雅黑", Font.BOLD, 32);
            //添加手机号，密码，昵称Jlabel
            pnText = new JLabel("手机号");
            pnText.setFont(font);
            pnText.setBounds(50, 50, 150, 50);
            pwdText = new JLabel("密码");
            pwdText.setFont(font);
            pwdText.setBounds(50, 150, 150, 50);
            nnText = new JLabel("昵称");
            nnText.setBounds(50, 250, 150, 50);
            pnTips = new JLabel();
            pnTips.setForeground(Color.red);
            pnTips.setBounds(350, 50, 150, 50);
            //添加手机号，密码，昵称JField
            pnField = new JTextField();
            pnField.setBounds(200, 50, 150, 50);
            pwdField = new JTextField();
            pwdField.setBounds(200, 150, 150, 50);
            nnField = new JTextField();
            nnField.setBounds(200, 250, 150, 50);
            //添加 注册、返回Button
            regBtn = new JButton("注册");
            regBtn.setBounds(200, 300, 100, 50);
            regBtn.setBackground(Color.getHSBColor(234, 113, 235));
            backBtn = new JButton("返回");
            backBtn.setBounds(80, 300, 100, 50);
            backBtn.setBackground(Color.getHSBColor(234, 113, 235));

            // 背景图片
            background = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Wpzhang\\resources\\注册背景图.jpg");
            //初始化主面板并添加
            mainPanel = new JLabel(background);

            mainPanel.add(pnText);
            mainPanel.add(pwdText);
            mainPanel.add(pnField);
            mainPanel.add(pwdField);
            mainPanel.add(regBtn);
            mainPanel.add(backBtn);

           //将主面板嵌入到窗体上
            this.add(mainPanel);

        }
        /**
         * @Param
         * @description 初始化窗体
         * @date 2019/5/12 23:06
         * @return
         */
        private void initFrame(){
            //初始化窗体
            this.setTitle("注册界面");
            this.setSize(500, 500);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    private void addBtnAction(){
        //添加返回按钮按键
        addBackBtnAction();
        //添加注册按钮按键
        addRegBtnAction();
    }
    /**
     * @Param
     * @description 添加返回按钮按键
     * @date 2019/5/12 23:02
     * @return
     */
   private void addBackBtnAction(){
       backBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               //销毁当前窗体
               dispose();
               //创建登录窗体
               new LoginFrame();
           }
       });
   }

    /**
     * @Param
     * @description 添加注册按钮按键
     * @date 2019/5/12 23:03
     * @return
     */
    private void addRegBtnAction(){
            regBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //采集用户注册信息(用User类保存)
                    String pn = pnField.getText();
                    String pwd = pwdField.getText();
                    String nn = nnField.getText();
                    User regUser = new User(pn, pwd, nn);
                    //TODO 合法性校验并提示
                /*
                手机号是否重复
                    -重复则做出提示
                    -不重复了就清空提示
                 */
                    pnTips.setText("");
                    if (!checkPNReapeat(pn)) {
                        pnTips.setText("手机号重复");
                        return;
                    }
                    //将注册信息持久化到数据库
                    saveUserInfo(regUser);
                    //注册成功跳转到登录界面
                    dispose();
                    new LoginFrame();
                }
            });
        }
        /**
         * @Param
         * @description 将User对象中的数据保存到数据库
         * @date 2019/5/12 23:40
         * @return
         */

  private void saveUserInfo(User regUser){
        Connection conn = DBUtil.getConnection();

      try {
          Statement  state = conn.createStatement();
          StringBuilder sb = new StringBuilder();
          sb.append("insert into t_user values (null,'")
                  .append(regUser.getPhonenum())
                  .append("','")
                  .append(regUser.getPassword())
                  .append("','")
                  .append(regUser.getNickname())
                  .append("')");
          System.out.println(sb.toString());
          int count = state.executeUpdate(sb.toString());
          if (count >= 1){
              System.out.println("保存数据成功");
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }finally{
          DBUtil.closeConnection(conn);
      }

    }

    //创建连接，创建语句对象，执行sql语句
    private static boolean checkPNReapeat(String pn) {
       Connection conn = DBUtil.getPoolConnection();
        try {
            Statement state =  conn.createStatement();
            String sql = "select count(1) from t_user where phonenumber = '" + pn + "'";
            System.out.println("执行的语句" + sql);
            ResultSet rs = state.executeQuery(sql);
            rs.next();
            if (rs.getInt(1)<= 0){
               //手机号不存在
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public static void main(String[] args) {
        new RegisterFrame();
    }

}