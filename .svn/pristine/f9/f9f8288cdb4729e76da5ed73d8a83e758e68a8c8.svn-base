<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>

  </head>
  
  <body>
    <div id="update">
	<form action="UpdateScmUser1">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td align="center">用户账号</td>
    <td align="center"><input type="text" readonly="readonly" value="${sUser.account}" name="account"/></td>
	</tr>
  <tr>
    <td align="center">用户名</td>
    <td align="center"><input type="text" name="name" value="${sUser.name}"/></td>
	</tr>
  <tr>
    <td align="center">密码</td>
    <td align="center"><input type="text" name="password" value="${sUser.password}"/></td>
	</tr>
	
  <tr>
    <td align="center">添加日期</td>
    <td align="center">
    	<input type="text" size="15" readonly="readonly" name="createdate" value="${sUser.createDate}">
    </td>
	</tr>
  <tr>
    <td align="center">锁定状态</td>
    <td align="center"><c:if test="${sUser.status eq 'y'}"><input type="radio" name="y" checked="checked" value="y"/>是 </c:if>
    				   <c:if test="${sUser.status eq 'n'}"><input type="radio" name="y" value="y"/>是 </c:if>
    				   <c:if test="${sUser.status eq 'y'}"><input type="radio" name="y" value="n"/>否 </c:if>
    				   <c:if test="${sUser.status eq 'n'}"><input type="radio" name="y" checked="checked" value="n"/>否 </c:if>
    </td>
	</tr>
  <tr>
    <td align="center">用户权限</td>
    <td align="center">
    	<input type="checkbox" <c:forEach items="${modelNameArr}" var="mn"><c:if test="${mn eq '人事'}">checked="checked"</c:if></c:forEach> name="gl" value="1"/>人事
    	<input type="checkbox" <c:forEach items="${modelNameArr}" var="mn"><c:if test="${mn eq '销售'}">checked="checked"</c:if></c:forEach> name="xs" value="2"/>销售
    	<input type="checkbox" <c:forEach items="${modelNameArr}" var="mn"><c:if test="${mn eq '财务'}">checked="checked"</c:if></c:forEach> name="cw" value="3"/>财务
    	<input type="checkbox" <c:forEach items="${modelNameArr}" var="mn"><c:if test="${mn eq '仓储'}">checked="checked"</c:if></c:forEach> name="cz" value="4"/>仓储
    	<input type="checkbox" <c:forEach items="${modelNameArr}" var="mn"><c:if test="${mn eq '采购'}">checked="checked"</c:if></c:forEach> name="cg" value="5"/>采购
    </td>
 </tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="reset"/> <input type="submit" value="保存"/></td>
    </tr>
</table>
</form>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>
