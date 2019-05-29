/**
 * @Author wpzhang
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servletDay05.dao.Impl;

import com.itek.servletDay05.dao.EmpDao;
import com.itek.servletDay05.domain.Emp;
import com.itek.servletDay05.util.DBUtil;
import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay05
 * @description:
 * @author: wpzhang
 * @create: 2019-05-28 18:50
 **/
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(Emp emp) {
        Connection conn =null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("insert into netctoss (name,job)values (?,?)");
            ps.setString(1,emp.getName());
            ps.setString(2,emp.getJob());
            int count = ps.executeUpdate();
            if (count >= 1){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            System.out.println("插入数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return-1;
    }

    @Override
    public List<Emp> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> emps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select deptno,name,job from netctoss");
            rs = ps.executeQuery();
            emps = new ArrayList<>();
            Emp emp = null;
            while (rs.next()){
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3));
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return emps;
    }

    @Override
    public int delEmp(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
           conn = DBUtil.getPoolConnection();
           ps = conn.prepareStatement("delete from netctoss where deptno =?");
           ps.setInt(1,deptno);
           int count = ps.executeUpdate();
           if (count >= 1){
               System.out.println("删除成功");
           }else {
               System.out.println("删除失败");
           }
        } catch (SQLException e) {
            System.out.println("删除数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return  -1;
    }

    @Override
    public int modEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("update netctoss set name =?,job =?where deptno =?");
            ps.setString(1,emp.getName());
            ps.setString(2,emp.getJob());
            ps.setInt(3,emp.getDeptno());
            int count = ps.executeUpdate();
            if (count >= 1){
                System.out.println("修改成功！");
            }else {
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }
}