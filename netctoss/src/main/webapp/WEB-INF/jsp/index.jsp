<%@page contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("base",request.getContextPath());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>宏晶信息－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" /> 
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
                <c:forEach var="menu" items="${menus}">
                <li><a href="${menu.href}" class="${menu.clazz}"></a></li>
                </c:forEach>
                <%--<li><a href="role/role_list.html" class="role_off"></a></li>--%>
                <%--<li><a href="admin/admin_list.html" class="admin_off"></a></li>--%>
                <%--<li><a href="fee/fee_list.html" class="fee_off"></a></li>--%>
                <%--<li><a href="account/account_list.html" class="account_off"></a></li>--%>
                <%--<li><a href="service/service_list.html" class="service_off"></a></li>--%>
                <%--<li><a href="bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="user/user_modi_pwd.html" class="password_off"></a></li>--%>
            </ul>
        </div>
    </body>
</html>
