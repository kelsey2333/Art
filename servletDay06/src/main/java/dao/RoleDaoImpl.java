/**
 * @Author wpzhang
 * @Date 2019/5/29
 * @Description
 */
package dao;

import domain.Role;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: servletDay06
 * @description: 接口实现类
 * @author: wpzhang
 * @create: 2019-05-29 15:48
 **/
public class RoleDaoImpl implements RoleDao {

    @Override
    public List<Role> selectAll() {
        Connection conn = DBUtil.getPoolConnection();
        String sql = "select r.id,r.role_name, GROUP_CONCAT(t.power_name) FROM t_role r LEFT JOIN t_role_power pr ON r.id = pr.role_id LEFT join t_power t on pr.power_id = t.id GROUP BY r.id";
        List<Role> roles = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            Role role = null;
            roles = new ArrayList<>();
           while (rs.next()) {
               String powerName = rs.getString(3);
               //当前powerName是一个字符串:角色管理，管理员管理，资金管理...
               List<String> rowPowerNames = Arrays.asList(powerName.split(","));
               System.out.println(rowPowerNames);
               role = new Role(rs.getInt(1), rs.getString(2),rowPowerNames);//只能进行查询，不能进行增删改，源代码会抛出异常
               roles.add(role);
           }
            return roles;

        } catch (SQLException e) {
            System.out.println("查询数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        //没有抛出异常时finally执行之后要返回null
//        抛出了异常就要返回null，因他还没有任何返回值，方法中是要求必须要返回东西的
        return null;
    }

    @Override
    public int delRole(int id) {
        Connection conn = DBUtil.getPoolConnection();
        try {
           PreparedStatement ps =  conn.prepareStatement("DELETE FROM t_role WHERE id = ?");
           ps.setInt(1,id);
           int count = ps.executeUpdate();
           if (count >= 1){
               System.out.println("删除成功");
           }else{
               System.out.println("删除失败");
           }return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return -1;
    }

    @Override
    public int addRole(Role role) {
        Connection conn = DBUtil.getPoolConnection();
        try {
            conn.prepareStatement("");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }
}