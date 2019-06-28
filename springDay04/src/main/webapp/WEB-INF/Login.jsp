<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>toLogin</legend>
    <form action="<%=request.getContextPath()%>/hello.do" method="post ">
        <input type="text" name="username"  placeholder="username">
        <input type="text" name="pwd" placeholder="password">
        <input type="submit" value="Button">
    </form>
</fieldset>

</body>
</html>
