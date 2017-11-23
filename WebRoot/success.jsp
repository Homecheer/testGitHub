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
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<c:if test="${empty powerError && empty error1}">
  	<c:if test="${not empty sUser }">
    	<span>${sUser.name}&nbsp;您好!&nbsp;&nbsp;&nbsp;&nbsp;请选择左边的菜单进行操作</span>
    </c:if>
    </c:if>
    <c:if test="${empty error1 }">
    <c:if test="${empty sUser }">
    	<span style="color: red">您尚未登入</span>
    </c:if>
    </c:if>
  <c:if test="${not empty error1 }"><span style="color: red">${error1}</span></c:if>
  <c:if test="${not empty powerError }"><span style="color: red">${powerError}</span></c:if>
  </body>
</html>
