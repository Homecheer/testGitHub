<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<title>标题</title>
<SCRIPT language=JavaScript>
	
function closeAlert() {
    	this.parent.location.href="login.jsp";
}

	function time() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month<10) month="0"+month;
		var day = date.getDate();
		if(day<10) day="0"+day;
		var house = date.getHours();
		if(house<10) house="0"+house;
		var minutes = date.getMinutes();
		if(minutes<10) minutes="0"+minutes;
		var second = date.getSeconds();
		if(second<10) second="0"+second;
		//var milsecond = date.getMilliseconds();
		document.getElementById("showtime").innerHTML = year + "-" + month
				+ "-" + day + " " + house + ":" + minutes + ":" + second;
		setTimeout("time()", 1000);
	}
</SCRIPT>
</head>

<body style="margin:0;" onload="time()">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" height="25">
  <tr>
    <td class="toolbar">用户账号：${sUser.account }</td>
    <td class="toolbar">用户姓名：${sUser.name }</td>
    <td class="toolbar">登录时间：${sUser.loginTime}</td>
    <td class="toolbar">系统时间： <font id="showtime"></font></td>
    <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="closeAlert()">
    <a href="javascript:void(0)"><img src="images/jrxt.jpg" border="0">登录</a></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="window.open('temp.jsp', 'mainFrame')">
    <a href="javascript:void(0)"><img src="images/lkxt.jpg" border="0">离开</a></td>
    <td width="20px" nowrap class="toolbar">|</td>
  </tr>
</table>

</body>
</html>
