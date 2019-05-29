package com.itek.servletDay05.dao;

import com.itek.servletDay05.domain.Emp;

import java.util.List;

public interface EmpDao {
    int addEmp(Emp emp);
    List<Emp> selectAll();
    int delEmp(int deptno);
    int modEmp(Emp emp);
}
