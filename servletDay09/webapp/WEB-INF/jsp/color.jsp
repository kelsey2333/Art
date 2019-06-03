<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/3
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>监听</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/reqParam">
    <fieldset>
    <legend>监听保存内容</legend>
        <label><input type="text" name="color" placeholder="your favorite color"><input type="submit" value="提交"></label>
    </fieldset>
    </form>
</body>
</html>
