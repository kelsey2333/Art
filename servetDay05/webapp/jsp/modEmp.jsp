<%@ page import="com.itek.servlet.day02.dao.EmpDao" %>
<%@ page import="com.itek.servlet.day02.dao.impl.EmpDaoImpl" %>
<%@ page import="com.sun.java.swing.plaf.windows.resources.windows" %>
<%@ page import="com.itek.servlet.day02.domain.Emp" %>
<%@ page import="com.itek.servletDay05.dao.EmpDao" %>
<%@ page import="com.itek.servletDay05.dao.Impl.EmpDaoImpl" %>
<%@ page import="com.itek.servletDay05.domain.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息页</title>
</head>
<style>
    fieldset{
        display: inline-block;
        width: 80px;
        margin-left:40%;
        margin-top:100px;
    }
</style>
<body>
<fieldset>
    <legend style="font-weight: bold">修改员工信息</legend>
    <form action="http://localhost:8080/servletDay05/mod/emp">
        <label>deptno</label><input type="hidden" name="deptno" value="<%=
        request.getParameter("deptno")
        %>"><br>
        <label>name</label><input type="text" name="name" value="<%=
        request.getParameter("name")
        %>"><br>
        <label>job</label><input type="text" name="job" value="<%=
        request.getParameter("job")
        %>"><br>
        <input type="submit" value="修改" style="width: 60px">
        <%
            String deptno = request.getParameter("deptno");
            String name = request.getParameter("name");
            String job = request.getParameter("job");
            System.out.println(deptno);
            System.out.println(name);
            System.out.println(job);
            EmpDao empDao = new EmpDaoImpl();
            empDao.modEmp(new Emp(Integer.parseInt(deptno),name,job));
        %>
    </form>
</fieldset>
</body>
</html>
