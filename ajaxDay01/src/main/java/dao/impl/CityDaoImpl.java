/**
 * @Author wpzhang
 * @Date 2019/6/14
 * @Description
 */
package dao.impl;

import dao.CityDao;
import domain.City;
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
 * @create: 2019-06-14 05:52
 **/
public class CityDaoImpl implements CityDao {
    @Override
    public List<City> selectCitiesByProcode(String provincecode) {
        Connection conn = DBUtil.getPoolConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select id , code , name , provincecode from city where provincecode =?");
            ps.setString(1,provincecode);
            ResultSet rs = ps.executeQuery();
            List<City> cities = new ArrayList<>();
            while (rs.next()){
                cities.add(new City(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return cities;
        } catch (SQLException e) {
            System.out.println("查询城市失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return null;
    }
}