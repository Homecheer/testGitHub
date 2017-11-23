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
    
    <title>库存变更记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript"></script>

  </head>
  
  <body>
     <div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－库存查询－－库存变更记录</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar"></td>
				<td width="20px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar"></td>
				<td nowrap class="toolbar"></td>
				<td width="60px" nowrap class="toolbar" ></td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" >&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" >&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" >&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		
		<table width="100%" border="0" align="center" cellspacing="1"
				class="c">
				<tr>
					<td class="title1">入库时间</td>
					<td class="title1">相关采购单号</td>
					<td class="title1">入库经手人</td>
					<td class="title1">入库数量</td>
					<td class="title1">入库类型</td>
				</tr>
			<c:forEach items="${alInStockRecord }" var="gd">

				<tr>
					<td align="center">${gd.stockTime }</td>
					<td align="center">${gd.orderCode }</td>
					<td align="center">${gd.createUser }</td>
					<td align="center">${gd.stockNum }</td>
					<td align="center">
						<c:if test="${gd.stockType eq 0}">采购入库</c:if>
						<c:if test="${gd.stockType eq 1}">盘点入库</c:if>
					</td>
				</tr>
			</c:forEach>
			
		</table><br/><br/>
		<table width="100%" border="0" align="center" cellspacing="1"
				class="c">
				<tr>
					<td class="title1">出库时间</td>
					<td class="title1">相关采购单号</td>
					<td class="title1">出库经手人</td>
					<td class="title1">出库数量</td>
					<td class="title1">出库类型</td>
				</tr>
			<c:forEach items="${alOutStockRecord }" var="gd">

				<tr>
					<td align="center">${gd.stockTime }</td>
					<td align="center">${gd.orderCode }</td>
					<td align="center">${gd.createUser }</td>
					<td align="center">${gd.stockNum }</td>
					<td align="center">
						<c:if test="${gd.stockType eq 0}">销售出库</c:if>
						<c:if test="${gd.stockType eq 1}">盘点出库</c:if>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
  </body>
</html>
