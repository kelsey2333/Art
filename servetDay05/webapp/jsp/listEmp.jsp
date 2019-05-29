<%@ page import="com.itek.servletDay05.dao.EmpDao" %>
<%@ page import="com.itek.servletDay05.dao.Impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.itek.servletDay05.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员列表页</title>
    <style>
        /*修改样式可以将body放在style中*/
        body {
            background-color:#0ea8d8;
            margin:0px;
        }
        .d1{
            background-color:#0ea8d8;
            border: 1px solid #ccc;
            margin:auto;
            width: 960px;
            height: 61px;
        }
        .d2{
            background-color:#0488bb;
            border:1px solid #ccc;
            height:91px;
        }
        .d3{
            background-color:#0ea8d8;
            border:1px solid #ccc;
            padding-top: 10px;
            height:410px;
        }
        .d4{
            background-color:#e8f3f8;
            margin:auto;
            border:5px solid #8ac1db ;
            width:950px;
            height:390px;
        }
        .d5{
            background-color:#e8f3f8;
            border:1px solid #ccc;
            margin:auto;
            width:910px;
            height:40px;
        }
        .d6{
            background-color:#e8f3f8;
            border:1px solid #ccc;
            margin:auto;
            width:910px;
            height:310px;
        }
        .d7{
            background-color:#e8f3f8;
            border:1px solid #ccc;
            margin:auto;
            width:910px;
            height:40px;
        }
        .d8{
            background-color:#0ea8d8;
            border:1px solid #ccc;
            margin:auto;
            height:50px;
            width:960px;
        }
        .setTxt{
            color: #e8f3f8;
            text-align: center;
        }
        .tab{
            /*合并边框*/
            border-collapse: collapse;
            /*设置宽度沾满整个一行，高度150px*/
            width:100%;
            height:150px;
            /*表格文本集居中，td继承table文本集居中样式*/
            text-align: center;
        }
        .tab_thead{
            background-color: #fbedce;
        }
        .tab_tbody{
            background-color:#f7f9fd;
        }
        tr:hover{
            /*背景色*/
            background-color:#cddde4;
            /*边框颜色*/
            border:#97b9c9;
            /*前景色*/
            color:#067db5;
        }
        .logoImage{
            position: relative;
            top: 0px;
            background-image: url("images/logo.png");
            height:91px;
            background-repeat: no-repeat;
        }
        .top_bg{
            background-image: url("images/top_bg.png");
            height: 91px;
            background-repeat: no-repeat;
        }
        .exit{
            line-height:55px ;
            color: #cccccc;
            float: right;
        }
        .msgNotice{
            border:1px solid orange;
            background-color: lightpink;
            width: 400px;
            height: 40px;
            position: fixed;
            bottom: 300px;
            left: 400px;
        }
        .okImage{
            position: absolute;
            top:12px;
        }
        .closeImage{
            position: absolute;
            top:0px;
            right:0px;
        }
        .span1{
            position: absolute;
            left:30px;
            top: 9px;
        }
        li{
            float: right;
            margin-right:120px ;
        }
        .li1{
            list-style-image: url("images/index_out.png");
        }
        .li2{
            list-style-image: url("images/role_out.png");
        }
        .li3{
            list-style-image: url("images/admin_out.png");
        }
        .li4{
            list-style-image: url("images/fee_out.png");
        }
        .li5{
            list-style-image: url("images/account_out.png");
        }
        .li6{
            list-style-image: url("images/service_out.png");
        }
        .li7{
            list-style-image: url("images/bill_out.png");
        }
        .li8{
            list-style-image: url("images/report_out.png");
        }
        .li9{
            list-style-image: url("images/information_out.png");
        }
        .li10{
            list-style-image: url("images/password_out.png");
        }
    </style>
</head>
<body>
<div class="d1">
    <div class="top_bg"> <div class="logoImage"><span class="exit">[退出]</span></div></div>

</div>
<div class="d2">
    <li class="li10"></li>
    <li class="li9"></li>
    <li class="li8"></li>
    <li class="li7"></li>
    <li class="li6"></li>
    <li class="li5"></li>
    <li class="li4"></li>
    <li class="li3"></li>
    <li class="li2"></li>
    <li class="li1"></li>

</div>
<div class="d3">
    <div class="d4">
        <div class="d5"></div>
        <div class="d6">
            <div class="msgNotice">
                <img class="okImage" src="images/ok.png">
                <span class="span1">操作成功！</span>
                <img class="closeImage" src="images/close.png">
            </div>

            <table class="tab" border=1px #97b9c9 width="910">
                <thead class="tab_thead">
                <tr >
                    <th><input type="checkbox">全选</th>
                    <th>管理员</th>
                    <th>姓名</th>
                    <th>拥有角色</th>
                    <th>操作</th>
                </tr>
                </thead>
                <%
                    EmpDao empDao = new EmpDaoImpl();
                    List<Emp> emps = empDao.selectAll();
                    for (Emp emp:emps){
                %>
                <tbody class="tab_tbody">
                <tr>
                    <td><input type="checkbox"></td>
                    <td><%=emp.getDeptno()%></td>
                    <td><%=emp.getName()%></td>
                    <td><%=emp.getJob()%></td>
                    <td>
                        <img  src="images/modification.png">
                        &nbsp;&nbsp;<a href="http://localhost:8080/servletDay05/jsp/modEmp.jsp?deptno=<%=emp.getDeptno()%>&name=<%=emp.getName()%>&job=<%=emp.getJob()%>"><input type="button" value="修改"></a>
                        <img src="images/delete.png">
                        &nbsp;<a href="http://localhost:8080/servletDay05/del/emp?deptno=<%=emp.getDeptno()%>"><input type="button" value="删除"></a>
                    </td>
                </tr>
                </tbody>
                <% } %>
            </table>
        </div>
        <div class="d7"></div>
    </div>
</div>
<div class="d8">
    <div class="setTxt">&lt;合肥市蜀山区望江西路800号创新产业园&gt;<br>
        版权所有@合肥宏晶信息</div>
</div>
</body>
</html>
