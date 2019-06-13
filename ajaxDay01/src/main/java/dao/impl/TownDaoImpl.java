/**
 * @Author wpzhang
 * @Date 2019/6/14
 * @Description
 */
package dao.impl;

import dao.TownDao;
import domain.Town;
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
 * @create: 2019-06-14 06:47
 **/
public class TownDaoImpl implements TownDao {
    @Override
    public List<Town> selectTownsByCitycode(String citycode) {
        Connection conn = DBUtil.getPoolConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select id , code , name , citycode from area where citycode =?");
            ps.setString(1,citycode);
            ResultSet rs = ps.executeQuery();
            List<Town> towns = new ArrayList<>();
            while (rs.next()){
                towns.add(new Town(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return towns;
        } catch (SQLException e) {
            System.out.println("查询乡镇失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return null;
    }
}