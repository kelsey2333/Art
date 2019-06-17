/**
 * @Author wpzhang
 * @Date 2019/6/12
 * @Description
 */
package dao.Impl;

import dao.AccountDao;
import domain.Account;
import util.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: netctoss
 * @description: 查询账务账号信息接口实现类
 * @author: wpzhang
 * @create: 2019-06-12 08:47
 **/
public class AccountDaoImpl implements AccountDao {
    @Override
    public List<Account> selectAll() {
        List<Account> accounts = new ArrayList<>();
        Connection conn = DBUtil.getPoolConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id,real_name,idcard_no,login_name,status,create_date,last_login_time FROM t_account");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer id  = rs.getInt(1);
                String realName = rs.getString(2);
                String idcardNo = rs.getString(3);
                String loginName = rs.getString(4);
                String status = rs.getString(5);
                Date createDate = rs.getDate(6);
                Date lastLoginTime = rs.getDate(7);
                Account account = new Account(id,realName,idcardNo,loginName,status,createDate,lastLoginTime);
                accounts.add(account);
            }
            return accounts;

        } catch (SQLException e) {
            System.out.println("查询账务账号信息列表失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Account> selectAllByPage(int pageNo, int pageSize, Account account) {
        Connection conn =  DBUtil.getPoolConnection();
        List<Account> accounts = new ArrayList<>();
        StringBuilder sb = null;
        try {
            int start = (pageNo -1) * pageSize;
            sb = new StringBuilder("SELECT id,real_name,idcard_no,login_name,status,create_date,last_login_time FROM t_account where 1 = 1 ");
            if (account.getIdcardNo() != null ){
                sb.append("and idcard_no like '%"+ account.getIdcardNo()+"%'");
            }
            if (account.getRealName() != null ){
                sb.append(" and real_name like '%"+ account.getRealName()+"%'");
            }
            if (account.getLoginName() != null){
                sb.append(" and login_name like '%"+ account.getLoginName() + "%'");
            }
            if (account.getStatus() != null && !account.getStatus().equals("-1")){
                sb.append(" and status like '%"+ account.getStatus()+"%'");
            }
            sb.append(" limit ?,? ");
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setInt(1,start);
            ps.setInt(2,pageSize);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                Integer id  = rs.getInt(1);
                String realName = rs.getString(2);
                String idcardNo = rs.getString(3);
                String loginName = rs.getString(4);
                String status = rs.getString(5);
                Date createDate = rs.getDate(6);
                Date lastLoginTime = rs.getDate(7);
                account = new Account(id,realName,idcardNo,loginName,status,createDate,lastLoginTime);
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            System.out.println("按页码查询账务账号失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return null;

    }



    /**
     * @Param
     * @description 计算记录条数
     * @date 2019/6/12 12:54
     * @return
     */
    @Override
    public int getSelectCount() {
        Connection conn = DBUtil.getPoolConnection();
        PreparedStatement ps = null;
        try {
                ps = conn.prepareStatement("select count(1) from t_account");
                ResultSet rs =  ps.executeQuery();
                rs.next();
                return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("获取查询次数失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }return -1;

    }

    @Override
    public int getFuzzyQueryCount(Account account) {
        Connection conn =  DBUtil.getPoolConnection();
        StringBuilder sb = null;
        try {
            sb = new StringBuilder("SELECT COUNT(1) FROM t_account where 1 = 1 ");
            if (account.getIdcardNo() != null ){
                sb.append("and idcard_no like '%"+ account.getIdcardNo()+"%'");
            }
            if (account.getRealName() != null ){
                sb.append(" and real_name like '%"+ account.getRealName()+"%'");
            }
            if (account.getLoginName() != null){
                sb.append(" and login_name like '%"+ account.getLoginName() + "%'");
            }
            if (account.getStatus() != null && !account.getStatus().equals("-1")){
                sb.append(" and status like '%"+ account.getStatus()+"%'");
            }
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs =  ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("按页码查询账务账号条数失败！");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public void addAccounts(Account addaccount) {
       Connection conn =  DBUtil.getPoolConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT into t_account ( id, recommender_id, login_name, login_passwd,status, create_date,pause_date ,close_date,real_name, idcard_no,birthdate, gender , " +
                                      " occupation , telephone , email , mailaddress , zipcode , qq , last_login_time , last_login_ip ) values ( null,null,?,?,?,null,null,null,?,?,?,?,?,?,?,?,?,?,null,null )");
            ps.setString(1,addaccount.getLoginName());
            ps.setString(2,addaccount.getLoginPasswd());
            ps.setString(3,addaccount.getStatus());
            ps.setString(4,addaccount.getRealName());
            ps.setString(5,addaccount.getIdcardNo());
            ps.setDate(6, java.sql.Date.valueOf(addaccount.getBirthday()));//将字符串转换成数据库中的日期
            ps.setString(7,addaccount.getGender());
            ps.setString(8,addaccount.getOccupation());
            ps.setString(9,addaccount.getTelephone());
            ps.setString(10,addaccount.getEmail());
            ps.setString(11,addaccount.getEmailaddress());
            ps.setString(12,addaccount.getZipcode());
            ps.setString(13,addaccount.getQq());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("插入数据失败");
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
    }
}