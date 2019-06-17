<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("base",request.getContextPath());
%>
<!DOCTYPE html >
<html>
    <head>
        <title>宏晶信息－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
        <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.4.3.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/json.js"></script>
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此账务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="${base}/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="${base}/index.html" class="index_off"></a></li>
                <li><a href="${base}/role/role_list.html" class="role_off"></a></li>
                <li><a href="${base}/admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="${base}/fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="${base}/account/account_list.html" class="account_on"></a></li>
                <li><a href="${base}/service/service_list.html" class="service_off"></a></li>
                <li><a href="${base}/bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="${base}/report/report_list.html" class="report_off"></a></li>
                <li><a href="${base}/user/user_info.html" class="information_off"></a></li>
                <li><a href="${base}/user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="${base}/list.acc" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" name="idCard" value="${param.idCard}" placeholder="不验证"  class="text_search" /></div>
                    <div>姓名：<input type="text" name="realName" value="${param.realName}" class="width70 text_search" placeholder="不验证"  /></div>
                    <div>登录名：<input type="text" name="loginName" value="${param.loginName}" placeholder="不验证"  class="text_search"/></div>
                    <div>
                        状态：
                        <select class="select_search" name="status">
                            <option value="-1" <c:if test="${param.status == '-1'}">selected</c:if>>全部</option>
                            <option value="1" <c:if test="${param.status == '1'}">selected</c:if>>开通</option>
                            <option value="0" <c:if test="${param.status == '0'}">selected</c:if>>暂停</option>
                            <option value="2" <c:if test="${param.status == '2'}">selected</c:if>>删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${base}/add.acc';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${base}/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->

                <div id="data">




                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>
                        <th class="width200"></th>
                    </tr>

                        <c:forEach var="account" items="${accounts}">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.realName}</td>
                            <td class="width150">${account.idcardNo}</td>
                            <td>${account.loginName}</td>
                            <td>
                                <c:if test="${account.status == '0'}">暂停</c:if>
                                <c:if test="${account.status == '1'}">开通</c:if>
                                <c:if test="${account.status == '2'}">删除</c:if>
                            </td>
                            <td class="width100">${account.createDate}</td>
                            <td class="width150">${account.lastLoginTime}</td>
                            <td class="td_modi">
                                <c:if test="${account.status == '1'}">
                                    <input type="button" value="暂停" class="btn_pause" onclick="setState();" />
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />
                                </c:if>
                                <c:if test="${account.status == '0'}">
                                    <input type="button" value="开通" class="btn_start" onclick="setState();" />
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />
                                </c:if>

                            </td>
                        </tr>
                        </c:forEach>
                </table>





                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="${base}/list.acc?pageNo=1&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">首页</a>
                    <c:if test="${curPage <= 1}">
                        <a href="${base}/list.acc?pageNo=1&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">上一页</a>
                    </c:if>
                    <c:if test="${curPage > 1}">
                        <a href="${base}/list.acc?pageNo=${curPage - 1}&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">上一页</a>
                    </c:if>
                    <!--处理endPage<5时 循环输出-->
                    <c:if test="${endPage <= 5}">
                        <c:forEach var="i" begin="1" end="${endPage}" step="1">
                            <c:if test="${curPage == i}">
                                <a href="${base}/list.acc?pageNo=${i}" class="current_page">${i}</a>
                            </c:if>
                            <c:if test="${curPage != i}">
                                <a href="${base}/list.acc?pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--处理endPage>=5时 -->
                    <c:if test="${endPage > 5}">
                        <c:choose>
                            <c:when test="${curPage == 1 || curPage == 2}">
                                <a href="${base}/list.acc?pageNo=1"<c:if test="${curPage == 1}"> class="current_page" </c:if>>1</a>
                                <a href="${base}/list.acc?pageNo=2"<c:if test="${curPage == 2}"> class="current_page" </c:if>>2</a>
                                <a href="${base}/list.acc?pageNo=3">3</a>
                                <a href="${base}/list.acc?pageNo=4">4</a>
                                <a href="${base}/list.acc?pageNo=5">5</a>
                            </c:when>
                            <c:when test="${curPage == endPage || curPage == endPage - 1 }">
                                <a href="${base}/list.acc?pageNo=${endPage-4}">1</a>
                                <a href="${base}/list.acc?pageNo=${endPage-3}">2</a>
                                <a href="${base}/list.acc?pageNo=${endPage-2}">3</a>
                                <a href="${base}/list.acc?pageNo=${endPage-1}"<c:if test="${curPage == endPage - 1}"> class="current_page" </c:if>>${endPage - 1}</a>
                                <a href="${base}/list.acc?pageNo=${endPage}"<c:if test="${curPage == endPage}"> class="current_page" </c:if>>${endPage}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${base}/list.acc?pageNo=${curPage-2}" >${curPage-2}</a>
                                <a href="${base}/list.acc?pageNo=${curPage-1}">${curPage-1}</a>
                                <a href="${base}/list.acc?pageNo=${curPage}" class="current_page">${curPage}</a>
                                <a href="${base}/list.acc?pageNo=${curPage+1}">${curPage+1}</a>
                                <a href="${base}/list.acc?pageNo=${curPage+2}">${curPage+2}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>

                    <c:choose>
                        <c:when test="${curPage == endPage}">
                            <a href="${base}/list.acc?pageNo=${endPage}&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">下一页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${base}/list.acc?pageNo=${curPage + 1}&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">下一页</a>
                        </c:otherwise>
                    </c:choose>
                    <a href="${base}/list.acc?pageNo=${endPage}&idCard=${param.idCard}&realName=${param.realName}&loginName=${param.loginName}&status=${param.status}">末页</a>
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
