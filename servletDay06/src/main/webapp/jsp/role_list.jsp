<%@ page import="dao.RoleDao" %>
<%@ page import="dao.RoleDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Role" %>
<%@page contentType="text/html; utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        function deleteRole() {
            var r = window.confirm("确定要删除此角色吗？");
            document.getElementById("operate_result_info").style.display = "block";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="/servletDay06/images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="/servletDay06/index.html" class="index_off"></a></li>
        <li><a href="/servletDay06/role/role_list.html" class="role_on"></a></li>
        <li><a href="/servletDay06/admin/admin_list.html" class="admin_off"></a></li>
        <li><a href="/servletDay06/fee/fee_list.html" class="fee_off"></a></li>
        <li><a href="/servletDay06/account/account_list.html" class="account_off"></a></li>
        <li><a href="/servletDay06/service/service_list.html" class="service_off"></a></li>
        <li><a href="/servletDay06/bill/bill_list.html" class="bill_off"></a></li>
        <li><a href="/servletDay06/report/report_list.html" class="report_off"></a></li>
        <li><a href="/servletDay06/user/user_info.html" class="information_off"></a></li>
        <li><a href="/servletDay06/user/user_modi_pwd.html" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <a href="http://localhost:8080/servletDay06/role/role_modi.html"><input type="button" value="增加" class="btn_add" onclick="location.href='role_add.html';"/></a>
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="<%=request.getContextPath()%>/images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <%
                    //创建jsp的好处就是用内置对象不用创建新对象
                    List<Role> roles = (List<Role>) request.getAttribute("allRoles");
                    System.out.println("集合roles: " + roles);
                    for (Role allRoles:roles){
                %>
                <tr>
                    <%--从数据库中加载数据动态加载--%>
                    <td><%=allRoles.getId()%></td>
                    <td><%=allRoles.getRoleName()%></td>
                    <td><%=allRoles.getPowerNames().toString()%></td>
                    <td>
                        <input type="button" value="修改" class="btn_modify" />
                        <%System.out.println( allRoles.getId());%>
                        <a href="http://localhost:8080/servletDay06/del.role?id=<%=allRoles.getId()%>"><input type="button" value="删除" class="btn_delete" /></a>
                    </td>
                </tr>
               <%}%>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[地址：合肥市高新区云飞路与文曲路交口创新产业园二期F4栋12层]</p>
    <p>版权所有&copy;合肥宏晶信息科技有限公司 </p>
</div>
</body>
</html>