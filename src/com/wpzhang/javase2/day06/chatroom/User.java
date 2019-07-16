/**
 * @Author wpzhang
 * @Date 2019/4/30
 * @Description
 */
package com.wpzhang.javase2.day06.chatroom;

/**
 * @program: Wpzhang
 * @description: 用户注册信息
 * @author: wpzhang
 * @create: 2019-04-30 16:09
 **/
public class User {
    public User(){}
    private Integer id;
    private String phonenum;
    private String password;
    private String nickname;

    public User(String phonenum, String password, String nickname){
        this.phonenum = phonenum;
        this.password = password;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}