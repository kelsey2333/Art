<%@page contentType="text/html; UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>宏晶信息－NetCTOSS</title>
        <%
        pageContext.setAttribute("base",request.getContextPath());
        %>
        <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
        <style>
            #btnBg{
                width: 124px;
                height: 41px;
                background-image: url("${base}/images/login_btn.png");
            }
        </style>
        <script>
            function checkLoginName() {
                var regExp = new RegExp("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$");
                alert("regExp:"+regExp);
                var loginNameVal = $("input[name = 'loginName']").value();
                if (!loginNameVal.match(regExp)){
                    alert("用户名错误！")
                }
            }
        </script>
    </head>
    <body class="index">
        <div class="login_box">
            <form action="${base}/checkLogin.role">
                <table>
                    <tr>
                        <td class="login_info">账号：</td>
                        <td colspan="2"><input name="loginName" type="text" class="width150" /></td>
                        <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                    </tr>
                    <tr>
                        <td class="login_info">密码：</td>
                        <td colspan="2"><input name="pwd" type="password" class="width150" /></td>
                        <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                    </tr>
                    <tr>
                        <td class="login_info">验证码：</td>
                        <td class="width70"><input name="captcha" type="text" class="width70" /></td>
                        <td><img src="<%=request.getContextPath()%>/captcha.role"  title="点击更换" onclick="this.src = '${base}/captcha.role?<%=Math.random()%>'" /></td>
                        <td><span class="required">${param.msg}</span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="login_button" colspan="2">
                            <input value="" type="submit" id="btnBg" onsubmit="checkLoginName();"/>
                        </td>
                        <td><span class="required"></span></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
