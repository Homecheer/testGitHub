<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js"></script>
	<script language="javascript" type="text/javascript">
		function displayOnePayTypeData(obj){  //展示某种付款方式的信息,类似过滤功能,在这里传值
			window.location.href="SelectPayTypeSomain?PayType="+obj.innerHTML;
		}
		function confirmOutStock(){
			var con=confirm("确定出库吗");
			if(con){
				return true;
			}else{
				return false
			}
		}
	</script>
  </head>

<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－出库登记</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar"></td>
			<td width="20px" nowrap class="toolbar"></td>
			<td width="40px" nowrap class="toolbar"></td>
			<td nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" ><a onclick="displayOnePayTypeData(this)">款到发货</a></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar"><a onclick="displayOnePayTypeData(this)">预付款到发货</a></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" ><a onclick="displayOnePayTypeData(this)">货到付款</a></td>
			<td width="20px" nowrap class="toolbar">|</td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellspacing="1">
		<tr>
			<td class="title1">销售单编号</td>
			<td class="title1">创建时间</td>
			<td class="title1">客户名称</td>
			<td class="title1">创建用户</td>
			<td class="title1">附加费用</td>

			<td class="title1">产品总价</td>
			<td class="title1">销售单总价格</td>
			<td class="title1">付款方式</td>
			<td class="title1">最低预付款金额</td>
			<td class="title1">处理状态</td>
			<td class="title1">操作</td>
		</tr>
		<c:forEach items="${alSO }" var="gd">
		<tr>
			<td align="center"><a href="Out_Detial?soid=${gd.soid }" target="mainFrame">${gd.soid }</a>
			</td>
			<td align="center">${gd.createTime }</td>
			<td align="center">${gd.customerName }</td>
			<td align="center">${gd.userName }</td>
			<td align="center">${gd.tipFee }</td>
			
			
			<td align="center">${gd.productTotal }</td>
			<td align="center">${gd.soTotal }</td>
			<td align="center">${gd.payType }</td>
			<td align="center">${gd.prePayFee }</td>
			<td align="center">
				<c:if test="${gd.status eq  1 && gd.payType eq '货到付款'}">新增的销售单</c:if>
				<c:if test="${gd.status eq  3 && gd.payType eq '款到发货'}">已付款的销售单</c:if>
				<c:if test="${gd.status eq  5 && gd.payType eq '预付款到发货'}">已预付的销售单</c:if>
			</td>
			
			<td align="center">
				<a href="/SCM/OutStock?soid=${gd.soid }" onclick="return confirmOutStock()">出库</a>
			</td>
		</tr>
	</c:forEach>

		<tr>
			<td class="title2"></td>
		</tr>
	</table>
</body>
</html>