/**
 * @Author wpzhang
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servletDay05.domain;

/**
 * @program: servletDay05
 * @description:
 * @author: wpzhang
 * @create: 2019-05-28 18:50
 **/
public class Emp {
    public Emp(){}

    public Emp(Integer deptno, String name, String job) {
        this.deptno = deptno;
        this.name = name;
        this.job = job;
    }

    private Integer deptno;
    private String name;
    private String job;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "deptno=" + deptno +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}