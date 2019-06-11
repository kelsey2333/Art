/**
 * @Author wpzhang
 * @Date 2019/6/10
 * @Description
 */
package dao.Impl;

import dao.UserDao;
import domain.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: netctoss
 * @description:
 * @author: wpzhang
 * @create: 2019-06-10 15:47
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUser(String loginName, String pwd) {
       Connection conn =  DBUtil.getPoolConnection();
       PreparedStatement ps = null;
       User user = null;
        try {
            ps = conn.prepareStatement("select * from t_admin where admin_code = ? and password = ?");
            ps.setString(1,loginName);
            ps.setString(2,pwd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("查询失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return null;
    }
}