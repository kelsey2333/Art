/**
 * @Author wpzhang
 * @Date 2019/6/11
 * @Description
 */
package dao.Impl;


import dao.AdminDao;
import domain.Menu;
import domain.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: netctoss
 * @description:t_admin表的Dao接口实现类
 * @author: wpzhang
 * @create: 2019-06-11 18:56
 **/
public class AdminDaoImpl implements AdminDao {
    @Override
    public User selectUser(String loginName) {
        Connection conn =  DBUtil.getPoolConnection();
        PreparedStatement ps = null;
        User user = null;
        try {
            ps = conn.prepareStatement("select * from t_admin where admin_code = ?");
            ps.setString(1,loginName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
                return user;
            }
        } catch (Exception e) {
            System.out.println("查询失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return null;
    }

    /**
     * @Param
     * @description 通过id查询菜单列表
     * @date 2019/6/12 5:27
     * @return
     */
    @Override
    public List<Menu> selectMenuById(Integer userId) {
        List<Menu> menus = new ArrayList<>();
       Connection conn =  DBUtil.getPoolConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT m.* FROM t_admin a " +
                    " LEFT JOIN t_admin_role ar " +
                    " ON a.id = ar.admin_id  " +
                    " LEFT JOIN t_role_menu rm  " +
                    " ON ar.role_id = rm.role_id " +
                    " LEFT JOIN t_menu m " +
                    " ON m.id = rm.menu_id " +
                    " where a.id = ? " +
                    " group by m.id ");
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            //解析结果集
            while(rs.next()){
                int id = rs.getInt(1);
                String href = rs.getString(2);
                String clazz = rs.getString(3);
                menus.add(new Menu(id,href,clazz));
            }return menus;
        } catch (SQLException e) {
            System.out.println("根据用户id查询菜单列表失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }
}