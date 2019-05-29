<%@ page import="com.itek.servlet.day02.dao.EmpDao" %>
<%@ page import="com.itek.servlet.day02.dao.impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.itek.servlet.day02.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表页</title>
</head>
<style>
    fieldset{
        display: inline-block;
        width: 50px;
    }
    table{
        border-collapse: collapse;
    }
    td,th{
        border: 1px solid lightskyblue;
    }
</style>
<script>

</script>
<body>

    <fieldset>
        <legend>员工列表</legend>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>sal</th>
                <th>age</th>
                <th colspan="2">oper</th>
            </tr>
            </thead>
            <%
                EmpDao empDao = new EmpDaoImpl();
                List<Emp> emps = empDao.selectAll();
                for (Emp emp:emps){
            %>
            <tbody>
            <tr>
                <td><%=emp.getId()%></td>
                <td><%=emp.getName()%></td>
                <td><%=emp.getSal()%></td>
                <td><%=emp.getAge()%></td>
                <td><a href="http://localhost:8080/servletDay02/del/emp?id=<%=emp.getId()%>"><input type="button" value="删除"></a></td>
                <td><a href="http://localhost:8080/servletDay02/jsp/modEmp.jsp?id=<%=emp.getId()%>&username=<%=emp.getName()%>&sal=<%=emp.getSal()%>&age=<%=emp.getAge()%>"><input type="button" value="修改"></a></td>
            </tr>
            </tbody>
            <% }%>
        </table>
    </fieldset>
</body>
</html>
