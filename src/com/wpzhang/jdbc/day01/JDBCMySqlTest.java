/**
 * @Author wpzhang
 * @Date 2019/4/29
 * @Description
 */
package com.wpzhang.jdbc.day01;


import java.sql.*;

/**
 * @program: Wpzhang
 * @description: JDBCMySql数据库测试
 * @author: wpzhang
 * @create: 2019-04-29 15:55
 **/
public class JDBCMySqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        执行过程：
        1、加载驱动，创建连接
        2、创建语句对象
        3、执行sql语句
        4、解析结果集
         */
        Class.forName("com.mysql.jdbc.Driver");//加载驱动
        Connection conn = DriverManager.getConnection("jdbc:MySql://localhost:3306/wpzhang",//建立连接
                                                            "root",
                                                            "ITEK");
        Statement stat =  conn.createStatement();//创建语句对象
        String sql = "select empno,ename,job from emp_wpzhang";//用创建出来的对象执行sql语句
        ResultSet rs  = stat.executeQuery(sql);//查询结果是一个结果集，所以用ResultSet接收
        /*
        解析结果集
            next()当前指针指向的下一行是否有数据
                -有：返回true
                -无：返回false
                -并且指针向下移动一位
                -打印输出字段对应的值:
                        -getXxx("字段名")：用来获取当前rs指针指向的记录中字段名对应的数据，
                                          并且该数据能自动转换成Xxx类型，若不能转换会出错
                        -getXxx(字段的索引值):用来获取当前rs指针指向的记录中字段索引值对应的数据。
                                          并且该数据能自动转换成 Xxx类型，否则会出错
         */
        while(rs.next()) {
            System.out.println(rs.getInt("empno") + ":" + rs.getString("ename") + ":" + rs.getString("job"));
        }
        conn.close();
    }
}