/**
 * @Author wpzhang
 * @Date 2019/4/29
 * @Description
 */
package com.wpzhang.jdbc.day01;


import java.sql.*;


/**
 * @program: Wpzhang
 * @description: JDBC测试
 * @author: wpzhang
 * @create: 2019-04-29 15:01
 **/
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、将数据库驱动类导入到工程项目中（类的全限定类名）
        //数据库驱动类里面包含的都是JDBC接口的实现类对象
     Class.forName("oracle.jdbc.OracleDriver");

        //2、获取数据库连接对象（connection是接口，返回的是接口的实现类对象）
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.226:1522:itek",
                                                            "java12",
                                                            "itek");
        //3、用获取到的连接对象创建语句对象
        Statement stat = conn.createStatement();
        //4、用创建好的语句对象来执行sql语句
        String sql = "select ename,comm from emp_wpzhang";
        ResultSet rs = stat.executeQuery(sql);//将sql语句发送到数据库服务器里进行执行，返回结果集
        //5、对结果集进行解析处理
        /*
            ResultSet类型返回的是boolean值
            next():判断当前指针下一位是否有数据
              有：返回true
              没有：返回false
              并且指针向下移动一位
              -getXxx("字段名")：用来获取当前rs指针指向的数据中对应字段的数据值
              -getXxx(字段的索引值)：从1开始
         */
        while(rs.next()){
            System.out.println(rs.getString("ename" ) + ":" + rs.getString("comm"));
        }
        //释放连接对象
        conn.close();
    }
}