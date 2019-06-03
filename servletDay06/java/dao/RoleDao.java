package dao;

import domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> selectAll();
    int delRole(int id);
    int addRoleName(String roleName);
    Integer receiveId(String roleName);
    int addRole(Integer roleId,Integer[] powerId);
}
