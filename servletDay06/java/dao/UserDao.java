package dao;

import domain.User;

public interface UserDao {
    User selectUser(String loginName, String pwd);
}
