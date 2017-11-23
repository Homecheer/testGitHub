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
    
    <title>My JSP 'count.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>提货</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js"></script>

  </head>
  
  <body>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－盘点管理</td>
  </tr>
</table>

<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">产品单编号</td>

	<td class="title1">名称</td>
    <td class="title1">当前库存</td>
       <td class="title1">采购在途数</td>
          <td class="title1">销售待发数</td>

    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${checkStockArr}" var="cs">
  <tr>
    <td align="center">${cs.productCode }</td>
    <td align="center">${cs.name}</td>
	<td align="center">${cs.num }</td>
    	<td align="center">${cs.PONum }</td>
	<td align="center">${cs.SONum }</td>

    <td align="center"><a href="CountToChange?productCode=${cs.productCode }&ysNum=${cs.num }">盘点</a></td>
  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<c:if test="${not empty pdSuccess }"><span style="color: red">${pdSuccess}</span></c:if>
  </body>
</html>
