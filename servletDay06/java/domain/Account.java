/**
 * @Author wpzhang
 * @Date 2019/6/12
 * @Description
 */
package domain;

import java.util.Date;
import java.util.Objects;

/**
 * @program: netctoss
 * @description: 账务账户信息列表类
 * @author: wpzhang
 * @create: 2019-06-12 08:36
 **/
public class Account {
    public Account(){}

    public Account(Integer id, String realName, String idcardNo, String loginName, String status, Date createDate, Date lastLoginTime) {
        this.id = id;
        this.realName = realName;
        this.idcardNo = idcardNo;
        this.loginName = loginName;
        this.status = status;
        this.createDate = createDate;
        this.lastLoginTime = lastLoginTime;
    }

    private Integer id;
    private String realName;
    private String idcardNo;
    private String loginName;
    private String status;
    private Date createDate;
    private Date lastLoginTime;

    public Account(String idCard, String realName, String loginName, String status) {
        this.idcardNo = idCard;
        this.realName = realName;
        this.loginName = loginName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", loginName='" + loginName + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(realName, account.realName) &&
                Objects.equals(idcardNo, account.idcardNo) &&
                Objects.equals(loginName, account.loginName) &&
                Objects.equals(status, account.status) &&
                Objects.equals(createDate, account.createDate) &&
                Objects.equals(lastLoginTime, account.lastLoginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realName, idcardNo, loginName, status, createDate, lastLoginTime);
    }
}