<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/29
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <fieldset>
        <legend>toLogin</legend>
        <form action="<%=request.getContextPath()%>/checkLogin.do">
            <input type="text" name="username" placeholder="yourName">
            <input type="text" name="password" placeholder="yourPassword">
            <input type="submit" value="button">
            <span>${param.msg}</span>
        </form>
    </fieldset>


</body>
</html>
