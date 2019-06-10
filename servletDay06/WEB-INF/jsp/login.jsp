<%@page contentType="text/html; UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>宏晶信息－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
        <style>
            #btnBg{
                width: 124px;
                height: 41px;
                background-image: url("<%=request.getContextPath()%>/images/login_btn.png");
            }
        </style>
    </head>
    <body class="index">
        <div class="login_box">
                <form action="<%=request.getContextPath()%>/checkLogin.role">
                    <table>
                    <tr>
                        <td class="login_info">账号：</td>
                        <td colspan="2"><input name="loginName" type="text" class="width150" /></td>
                        <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                    </tr>
                    <tr>
                        <td class="login_info">密码：</td>
                        <td colspan="2"><input name="pwd" type="password" class="width150" /></td>
                        <td><span class="required">30长度的字母、数字和下划线</span></td>
                    </tr>
                    <tr>
                        <td class="login_info">验证码：</td>
                        <td class="width70"><input name="captche" type="text" class="width70" /></td>
                        <td><img src="<%=request.getContextPath()%>/captche.role" alt="验证码" onclick="this.src='<%=request.getContextPath()%>/captche.role<%=Math.random()%>'" /></td>
                        <td><span class="required">验证码错误</span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="login_button" colspan="2">
                            <%--todo --%>
                            <input id="btnBg" type="submit" value="" >
                        </td>
                        <td><span class="required">用户名或密码错误，请重试</span></td>
                    </tr>
                    </table>
                </form>
        </div>
    </body>
</html>
