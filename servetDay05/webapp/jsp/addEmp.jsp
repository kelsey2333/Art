
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工信息</title>
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
    <legend style="font-weight: bold">提交员工信息</legend>
    <form action="http://localhost:8080/servletDay05/add/emp">
        <label>name</label><input type="text" name="name">
        <label>job</label><input type="text" name="job">
        <input type="submit" value="提交" style="width: 80px">
    </form>
</fieldset>
</body>
</html>
