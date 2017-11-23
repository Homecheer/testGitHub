<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findorder.jsp' starting page</title>
    <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
   <script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script type="text/javascript" src="/SCM/script/jquery-ui-timepicker-addon.js"></script>
  <script type="text/javascript" src="/SCM/script/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript">
	function enter(obj){
		var x=obj.parentNode.parentNode.cells[1];
		var i=$(x).children("a:first").text();
		location="ShowDetail?num="+i;
	}function successdel(){
		alert("删除成功");
	}
</script>
    <link href="css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="<c:if test="${not empty successdel }">successdel()</c:if>">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单查询</td>
		</tr>
	</table>
	<div class="formVisiblitly" id="formDiv"></div>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
 		<tr>
			<td nowrap class="toolbar">&nbsp;</td>
 	 	</tr>
	</table>
<form action="EnterFindServlet" method="post">
	<table id="headTable" width="100%"  border="0" align="center" class="a1">
  		<tr align="justify">
   	 		<td>销售单编号</td>
    		<td><input type="text" name="i1" size="15"/>
     		 <span class="requred_symbol">*</span></td>
    		<td>创建时间</td>
    		   
    		 <td>
    		 	<input name="i2" type="text" size="15"  readonly="readonly"/>
    		 	 <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.i2);return false;">
        <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
    		 </td>  
    		   		   		
   			<!--   <td><select name="i2">
   			 	<option></option>	
    			<c:forEach items="${altime }" var="aa">
    				<option>${aa }</option>
    			</c:forEach>       	
      		 </select>
     		 <span class="requred_symbol">*</span></td> -->
     		 
     		 
   			 <td>客户编号</td>
    		<td><select name="i3">
    		<option></option>	
    			<c:forEach items="${alname }" var="a">
    				<option>${a }</option>
    			</c:forEach>       	
      		 </select> </td>
   		 <td>付款方式</td>
    		<td>
    	<select name="i4">
    		<option></option>	
    		<option>货到付款</option>	
    		<option>预付款发货</option>	
    		<option>款到发货</option>	
        </select>
    </td>
  </tr>
</table>
<div align="center">
    <input type="submit" value="查询" >
    <input type="reset">
</div>


</form>	

<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">&nbsp;</td>
    <td class="toolbar">采购单编号 </td>
    <td class="toolbar">创建时间 </td>
    <td class="toolbar">客户编号 </td>
    <td class="toolbar">付款方式</td>
    <td class="toolbar">订单总价</td>
    <td class="toolbar">操作</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
  <c:forEach items="${infor }" var="infor">
  <tr>
    <td class="toolbar">&nbsp;</td>
    <td class="toolbar"><a onclick="enter(this)">${infor.getSOID() }</a> </td>
    <td class="toolbar">${infor.getCreateTime() }</td>
    <td class="toolbar">${infor.getCustomerCode() }</td>
    <td class="toolbar">${infor.getPayType() }</td>
    <td class="toolbar">${infor.getSOTotal() }</td>
    <td class="toolbar"><input type="button" value="删除"><input type="button" value="修改"></td>
    <td class="toolbar">&nbsp;</td>
  </tr>
  
  </c:forEach>
</table>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="/SCM/common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>
