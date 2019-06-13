/**
 * @Author wpzhang
 * @Date 2019/6/13
 * @Description
 */
package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import net.sf.json.JSONArray;
import util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: wpzhang
 * @create: 2019-06-13 17:10
 **/
public class ProvinceDaoImpl implements ProvinceDao {
    @Override
    public List<Province> selectAllProvinces() {
        Connection conn = DBUtil.getPoolConnection();
        List<Province> provinces = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select id,code,name from province");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                provinces.add(new Province(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)
                        )
                );
            }
           return provinces;
        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return null;
    }
}