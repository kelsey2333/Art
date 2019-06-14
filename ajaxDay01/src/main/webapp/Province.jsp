<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/13
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城市下拉选</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.4.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/json.js"></script>
    <script>

        //获取ajax对象
        function getAjaxObj() {
            var  ajax = null;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest;
            }else{
                ajax = new ActiveXObject('Microsoft.XMLHttp');
            }
            return ajax;
        }

        //获取省份
        //当出现一直停留在parseJSON前时可能是两个js的问题
        function getProvinces() {
            var ajax = getAjaxObj();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200){
                    var str = ajax.responseText;
                    var provinces = str.parseJSON()
                    for (var i = 0;i < provinces.length;i++){
                        $("#provinces").append("<option value='"+ provinces[i].code +"'>"+provinces[i].name+"</option>");
                    }
                }
            };
            ajax.open("get","/ajax/list.province",true);
            ajax.send();
        }

        //获取城市
        function getCities() {
            var code  = $("#provinces").val();
            var ajax = getAjaxObj();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200){
                    var str = ajax.responseText;
                    var cities =  str.parseJSON();
                    $("#cities").children().remove();
                    for (var i = 0;i < cities.length;i++){
                        $("#cities").append("<option value='"+ cities[i].code +"'>"+ cities[i].name +"</option>")
                    }
                    getTowns();
                }
            };
            ajax.open("get","/ajax/city.province?code=" + code,true);
            ajax.send();
        }

        //获取乡镇
        function getTowns() {
            var code  = $("#cities").val();
            var ajax = getAjaxObj();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200){
                    var str = ajax.responseText;
                    var towns =  str.parseJSON();
                    $("#towns").children().remove();
                    for (var i = 0;i < towns.length;i++){
                        $("#towns").append("<option value='"+ towns[i].code +"'>"+ towns[i].name +"</option>")
                    }
                }
            };
            ajax.open("get","/ajax/town.province?code=" + code,true);
            ajax.send();
        }

    </script>
</head>
<body onload="getProvinces()">
    <label>省份</label>
    <select id="provinces" onchange="getCities()">
        <option value="-1">--请选择--</option>
    </select>
    <label>城市</label>
    <select id="cities" onchange="getTowns()"  >
        <option value="-1">--请选择--</option>
    </select>
    <label>乡镇</label>
    <select id="towns">
        <option value="-1">--请选择--</option>
    </select>
</body>
</html>
