package com.itek.servlet.day02.dao;

import com.itek.servlet.day02.domain.Emp;

import java.util.List;

public interface EmpDao {
    int addEmp(Emp emp);
    List<Emp> selectAll();
    int deleteById(int id);
    int modify(Emp emp);
}
