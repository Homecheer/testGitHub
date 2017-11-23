<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCM</title>
</head>

<frameset rows="25,10,*" cols="*" frameborder="NO" border="0" framespacing="0" id="controlRv">
  <frame src="title.jsp" name="topFrame" scrolling="NO" noresize >
  <frame src="dynamic_bar_h.jsp" scrolling="no" name="sidebar_r" noresize>
  <frameset cols="120,10,*" frameborder="NO" border="0" framespacing="0"  id="controlFv">
    <frame src="catalog.jsp" name="leftFrame" scrolling="NO" noresize>
	<frame src="dynamic_bar_v.jsp" scrolling="no"  name="sidebar_v" noresize>
    <frame src="success.jsp" name="mainFrame" scrolling="auto">
  </frameset>
</frameset>
<noframes></noframes>
</html>