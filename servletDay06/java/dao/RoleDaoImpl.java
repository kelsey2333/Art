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
           while (rs.next()) {
               role = new Role(rs.getInt(1), rs.getString(2));
               String powerName = rs.getString(3);
               roles = new ArrayList<>();
               //当前powerName是一个字符串:角色管理，管理员管理，资金管理...
               List<String> rowPowerNames = Arrays.asList(powerName.split(","));
               role.setPowerNames(rowPowerNames);
               roles.add(role);
               System.out.println(roles);
           }
        } catch (SQLException e) {
            System.out.println("查询数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return roles;
    }
}