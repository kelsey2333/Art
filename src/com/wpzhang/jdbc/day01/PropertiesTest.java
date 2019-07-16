/**
 * @Author wpzhang
 * @Date 2019/4/29
 * @Description
 */
package com.wpzhang.jdbc.day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @program: Wpzhang
 * @description: 配置信息测试
 * @author: wpzhang
 * @create: 2019-04-29 18:43
 **/
public class PropertiesTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        /*
        加载驱动
        创建连接
        创建语句对象
        执行sql语句
        解析结果集
         */
        //获取输入流，将properties文件中的数据加载到集合prop中
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\IdeaProjects\\Wpzhang\\src\\com\\wpzhang\\jdbc\\day01\\JDBC.properties");
        Properties prop = new Properties();
        prop.load(fis);
        Class.forName((String)prop.get("driver"));//加载驱动
        //创建连接
        Connection conn = DriverManager.getConnection(
                (String)prop.get("url"),
                (String)prop.get("name"),
                (String)prop.get("pwd")
        );
        //获取语句对象
        Statement stat =  conn.createStatement();
        //执行sql语句
        String sql = "select empno,ename,job from emp_wpzhang";
        ResultSet rs = stat.executeQuery(sql);
        //循环解析结果集
        while(rs.next()){
            System.out.println(rs.getString("empno") + ":" + rs.getString("ename") + ":" + rs.getString("job"));
        }
        //关闭连接
        conn.close();
    }
}