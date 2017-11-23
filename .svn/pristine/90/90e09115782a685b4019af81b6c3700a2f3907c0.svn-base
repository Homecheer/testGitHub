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
    
    <title>My JSP 'inMoney.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js"></script>
	<script type="text/javascript">
		function inMoney(){
			var flag=confirm("是否要收款");
			if(flag){
				return true;
				}else{
					return false;
				}
		}
	</script>
  </head>
  
  <body>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－收款登记</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="65px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a href="SoMain?type=2">预付款发货</a></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="65px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a href="SoMain?type=1">款到发货</a></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="65px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a href="SoMain?type=0">货到付款</a></td>
    <td width="20px" nowrap class="toolbar">|</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">销售单编号</td>
    <td class="title1">创建时间</td>
	<td class="title1">客户</td>
	<td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
 	<td class="title1">产品总价</td>
    <td class="title1">销售单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>
 <c:forEach items="${aList}" var="al">
  <c:if test="${(al.payType eq '货到付款' && al.status eq '2')||(al.payType eq '款到发货' && al.status eq '1')||(al.payType eq '预付款到发货' && al.status eq '2' || (al.payType eq '预付款到发货' && al.status eq '1'))}">
  <tr>
    <td align="center"><a href="SoItem?soid=${al.soid }" id="soid">${al.soid }</a></td>
    <td align="center">${al.createTime }</td>
	<td align="center">${al.customerName }</td>
	<td align="center" id="endUser">${al.userName }</td>
    <td align="center">${al.tipFee }</td>
 	<td align="center">${al.productTotal }</td>
    <td align="center">${al.soTotal }</td>
    <td align="center">${al.payType }</td>
    <td align="center">${al.prePayFee }</td>
    <td align="center"><c:if test="${al.status eq '2' && al.payType eq '货到付款'}">未收款</c:if><c:if test="${al.status eq '1' && al.payType eq '款到发货'}">未收款</c:if><c:if test="${al.status eq '1' && al.payType eq '预付款到发货'}">未预收</c:if><c:if test="${al.status eq '2' && al.payType eq '预付款到发货'}">已到货,收余款</c:if></td>
    <td align="center"><a href="InMoney?status=${al.status}&soid=${al.soid }&endUser=${al.userName }&payType=${al.payType}" onclick="return inMoney(this)">收款</a></td>
  </tr>
  </c:if>
</c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<c:if test="${not empty inMoneyError }"><span style="color: red">${inMoneyError}</span></c:if>
  </body>
</html>
