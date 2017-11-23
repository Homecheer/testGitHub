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
    <script type="text/javascript">
    	function detail(obj){
    		var soid=obj.innerHTML;
    		location="FinishServlet?show='123'&soid="+soid;
    	}function finish(obj){
    		var soid=$(obj.parentNode.parentNode.cells[0]).children("a:first").text();
    		location="FinishServlet?finish='123'&soid="+soid;
    	}    
    
    </script>
    <title>My JSP 'ljso.jsp' starting page</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
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
    	 <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单了结</td>
		</tr>
	</table>
	<div class="formVisiblitly" id="formDiv"></div>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
 		<tr>
			<td nowrap class="toolbar">&nbsp;</td>
 	 	</tr>
	</table>
	<table  id="detailtable1" width="100%"  border="0" align="center" class="a1">
  		<tr align="justify">
   	 		<td>销售单编号</td>
    		<td>付款方式</td>
   			<td>客户编号</td>
    		<td>操作</td>
  		</tr>
  		<c:forEach items="${al }" var="x">
  		<tr>
  			<td><a onclick="detail(this)">${x.getOrder() }</a></td>
  			<td>${x.getPaytype() }</td>
  			<td>${account }</td>
  			<td><input type="button" value="了结" onclick="finish(this)"></td>
  		</tr>
  		</c:forEach>
	</table>
	
	<table id="headTable" width="100%"  border="0" align="center" class="a1" style="margin-top:50px; ">
  <tr align="justify">
    <td >销售单编号</td>
    <td><input name="num" type="text" size="15" value="${sm.getSOID() }" id="iorder" readonly="readonly"/></td>
    <td>创建时间</td>
    <td><input name="t4" type="text" size="15" value="${sm.getCreateTime() }" readonly="readonly"/></td>
    <td >客户名称</td>
    <td>
    	<input type="text" size="15" value="${sm.getCustomerCode() }">
     </td>
    <td>创建用户</td>
    <td>
   	 	<input type="text" size="15" value="${sm.getAccount()}">
    </td>
  </tr>
  <tr align="justify">
    <td>附加费用</td>
    <td><input name="t5" type="text" size="15" value="${sm.getTipFee() }"/></td>
    <td>产品总价</td>
    <td><input  name="t6" type="text" size="15" value="${sm.getProductTotal() }" style=""disabled="disabled"/></td>
    <td>付款方式</td>
    <td>
    	<select id="s1" name="t8">
    			<option  <c:if test="${sm.getPayType() eq '预付款发货'}">selected</c:if>>预付款发货</option>
    			<option  <c:if test="${sm.getPayType() eq '货到付款'}">selected</c:if>>货到付款</option>
    			<option  <c:if test="${sm.getPayType() eq '款到发货'}">selected</c:if>>款到发货</option>
    	</select>
    	
    </td>
    <td>最低预付金额</td>
    	<td><input  type="text" name="t9" id="prepay" size="15" value="${sm.getPrePayFee() }" readonly="readonly" onclick="changeprepay()"/></td>
   </tr>
 
  <tr>
  	<td>出库登记时间</td>
  	 <td><input type="text" size="15" name="t12" value="${sm.getStockTime() }"/></td>
  	<td>出库登记用户</td>
  	<td><input type="text" size="15" name="t13" value="${sm.getStockUser() }"/></td>
  	<td>付款登记时间</td>
  	<td><input type="text" size="15" name="t14" value="${sm.getPayTime() }"/></td>
  	<td>付款登记用户</td>
  	<td><input type="text" size="15" name="t15" value="${sm.getPayUser() }"/></td>
  </tr>
 
  <tr>
  	<td>预付登记时间</td>
  	<td><input type="text" size="15" name="t16" value="${sm.getPrePayTime() }"/></td>
  	<td>预付登记用户</td>
  	<td><input type="text" size="15" name="t17" value="${sm.getPrePayUser() }"/></td>
  	<td>了结时间</td>
  	<td><input type="text" size="15" name="t18" value="${sm.getEndTime() }"/></td>
 	 <td>了结用户</td>
 	 <td><input type="text" size="15" name="t19" value="${sm.getEndUser() }"/></td>
  </tr> 
 
  
  </form>
  
</table>			
	
	
	
	
  </body>
</html>
