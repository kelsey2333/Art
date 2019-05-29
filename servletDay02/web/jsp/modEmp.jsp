<%@ page import="com.itek.servlet.day02.dao.EmpDao" %>
<%@ page import="com.itek.servlet.day02.dao.impl.EmpDaoImpl" %>
<%@ page import="com.sun.java.swing.plaf.windows.resources.windows" %>
<%@ page import="com.itek.servlet.day02.domain.Emp" %>
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
    <form action="http://localhost:8080/servletDay02/mod/emp">
        <label>id</label><input type="hidden" name="id" value="<%=
        request.getParameter("id")
        %>"><br>
        <label>name</label><input type="text" name="username" value="<%=
        request.getParameter("username")
        %>"><br>
        <label>sal</label><input type="text" name="sal" value="<%=
        request.getParameter("sal")
        %>"><br>
        <label>age</label><input type="text" name="age" value="<%=
        request.getParameter("age")
        %>"><br>
        <input type="submit" value="修改" style="width: 60px">
        <%
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String sal =  request.getParameter("sal");
            String age =  request.getParameter("age");
            System.out.println(username);
            System.out.println(sal);
            System.out.println(age);
            EmpDao empDao = new EmpDaoImpl();
            empDao.modify(new Emp(Integer.parseInt(id),username,Double.parseDouble(sal),Integer.parseInt(age)));
        %>
    </form>
</fieldset>
</body>
</html>
