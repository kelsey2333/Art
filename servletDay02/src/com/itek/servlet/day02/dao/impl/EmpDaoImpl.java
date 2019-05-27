/**
 * @Author wpzhang
 * @Date 2019/5/24
 * @Description
 */
package com.itek.servlet.day02.dao.impl;

import com.itek.servlet.day02.dao.EmpDao;
import com.itek.servlet.day02.domain.Emp;
import com.itek.servlet.day02.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay02
 * @description: EmpDao接口的所有实现类对象。实现接口中的操作数据库数据的方法
 * @author: wpzhang
 * @create: 2019-05-24 13:12
 **/
public class EmpDaoImpl implements EmpDao {

    /**
     * @Param
     * @description 添加数据
     * @date 2019/5/24 19:42
     * @return
     */

    @Override
    public int addEmp(Emp emp) {
        //将数据保存起来到数据库
        //加载驱动
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //获取连接
            conn = DBUtil.getPoolConnection();
            //创建语句对象
            ps = conn.prepareStatement("INSERT  into javaemp_wpzhang (name,sal,age)values(?,?,?)");
            //设置占位符
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSal());
            ps.setInt(3, emp.getAge());

            //执行sql语句
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            System.out.println("插入数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
}
    /**
     * @Param
     * @description 全选数据库数据显示在浏览器
     * @date 2019/5/24 19:41
     * @return
     */

    @Override
    public List<Emp> selectAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> emps = null;
        Emp emp = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select id,name ,sal,age from javaEmp_wpzhang ");
            rs =  ps.executeQuery();
            //解析结果集
            emps = new ArrayList<Emp>();
            while(rs.next()){
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
                //todo add里添加的是对象？？
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return emps;
    }

    /**
     * @Param
     * @description 删除数据
     * @date 2019/5/24 19:42
     * @return
     */

    @Override
    public int deleteById(int id) {
        //将数据库中数据删除
        //加载驱动
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //获取连接
            conn = DBUtil.getPoolConnection();
            //创建语句对象
            ps = conn.prepareStatement("delete from javaEmp_wpzhang where id = ?");
            //设置占位符
            ps.setInt(1,id);
            //执行sql语句
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            return count;
        } catch (SQLException e) {
            System.out.println("删除数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public int modify(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DBUtil.getPoolConnection();
        try {
            ps = conn.prepareStatement("update javaEmp_wpzhang set name=?,sal =?,age=? where id=?");
            ps.setInt(4,emp.getId());
            ps.setString(1,emp.getName());
            ps.setDouble(2,emp.getSal());
            ps.setInt(3,emp.getAge());
            int count= ps.executeUpdate();

            if (count >= 1){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }return count;

        } catch (SQLException e) {
            System.out.println("修改数据失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }


}