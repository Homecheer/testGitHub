<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.inp{height:23px;width:99%}
</style>
<script src="/SCM/script/jquery-1.8.1.min.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){$(".inp,:reset").click(function(){$("span").text("")});});
</script>
</head>
<body bgcolor="#ffffff" >

<form action="login" method="post">
<table width="350px"  border="0" style="margin:200px auto" height="150px">
	<tr><th colspan="2">SCM系统登录</th></tr>
  <tr>
    <td width="30%" align="center">帐&nbsp;&nbsp;&nbsp;&nbsp;号</td>
    <td width="70%"><input type="text" name="name" class="inp"
    <c:if test="${not empty name_temp}">value="${name_temp}"</c:if>
    /></td>
  </tr>
  <tr>
    <td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
    <td ><input type="password" name="password" class="inp"/></td>
  </tr>
  <tr>
  	<td colspan="2" ><input type="submit" value="登录"/> <input type="reset" value="重置" />
  	<c:if test="${not empty error }"><span style="color: red">${error}</span></c:if>
		<c:if test="${not empty statusError }"><span style="color: red">${statusError}</span></c:if></td>
  </tr>
</table>
</form>
<%request.getSession().invalidate(); %>
</body>
</html>
