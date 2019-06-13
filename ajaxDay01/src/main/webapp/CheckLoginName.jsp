<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/13
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校验用户名是否存在</title>
    <script src="jquery-1.4.3.js"></script>
    <script>

        function checkLoginName() {
            //获取ajax对象
            var ajax = getAjaxObj();
            //绑定onreadystatechange事件  开始监听状态的改变，并响应
            ajax.onreadystatechange = function () {
                //readyState是请求的状态 0 1 2 3 4
                if (ajax.readyState == 4 && ajax.status == 200) {
                    if (ajax.responseText == "1") {
                        alert("用户名可以使用")
                    } else if (ajax.responseText == "0") {
                        alert("用户名已被占用，请另取他名")
                    }
                }
            };

                //获取用户名
                // var loginName = $("#loginName").val();
                var loginName = document.getElementById("loginName").value;
                //将用户名发送给servlet
                ajax.open("get","check.login?loginName=" + loginName ,true);
                ajax.send(null);

        }
        function getAjaxObj() {
            var  ajax = null;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest;
            }else{
                ajax = new ActiveXObject('Microsoft.XMLHttp');
            }
            return ajax;
        }
    </script>
</head>
<body>
    <fieldset>
        <legend>校验用户名</legend>
        <label>
            <input type="text" id="loginName" name="loginName">
            <input type="submit" value="校验" onclick="checkLoginName();">
        </label>
    </fieldset>
</body>
</html>
