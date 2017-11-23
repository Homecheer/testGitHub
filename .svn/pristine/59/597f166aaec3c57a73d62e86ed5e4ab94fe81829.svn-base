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
    
    <title>My JSP 'showdetail.jsp' starting page</title>
     <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
  	 <script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<script type="text/javascript">
		function delitem(obj){
			var i=$(obj).parent().children("span:first").text();
			var x=$(obj).parent().children("span:eq(1)").text();
			location="ShowDetail?del1="+i+"&del2="+x+"&num="+i;
		}
		function additem(obj){
			
			var add="123";
			var iorder=$("#iorder").val();
			var spbm= $(obj).text();
			var spnum=$(obj.parentNode.parentNode.cells[2]).children("input:first").val();
			var shuliangdanwei=obj.parentNode.parentNode.cells[3].innerHTML;
			var danjia=$(obj.parentNode.parentNode.cells[4]).children("input:first").val();
			location="ShowDetail?num="+iorder+"&add="+add+"&spbm="+spbm+"&spnum="+spnum+"&shuliangdanwei="+shuliangdanwei+"&danjia="+danjia;
		
		}
		function err(){
		alert("输入格式有误，添加失败");
		}
		function cancel(){
			document.getElementById("detailTable").style.display="none";
			document.getElementById("headTable").style.display="block";
		}
		function show(){
		document.getElementById("detailTable").style.display="block";
			document.getElementById("headTable").style.display="none";
		}
		function changeprepay(){
		var i=document.getElementById("s1").selectedIndex;
		if(i==0){
			$("#prepay").attr("readOnly",false);
		}else{
			$("#prepay").attr("readOnly",true);
		}
		}function start(){
		
		}function dup(){
			alert("同一订单下不能拥有相同的商品");
		}function delmain(){
			var iorder=$("#iorder").val();
			location="ShowDetail?num="+iorder+"&delmain=123";
		}function faildel(){
			alert("删除失败");
		}function statuserror(){
			alert("已付款的商品订单不能删除");
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
  
  <body onload="start()<c:if test="${not empty err }">;err()</c:if><c:if test="${not empty doubleproduct }">;dup()</c:if><c:if test="${not empty faildel }">;faildel()</c:if><c:if test="${not empty statuserror }">;statuserror()</c:if>"  >
    	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单详情</td>
		</tr>
	</table>			
   <table width="100%"  border="0" cellpadding="0" cellspacing="0">
 		<tr>
			<td nowrap class="toolbar">&nbsp;</td>
 	 	</tr>
	</table> 				
    				
   

<table id="headTable" width="100%"  border="0" align="center" class="a1">
<form action="ShowDetail">
  <tr align="justify">
    <td >销售单编号</td>
    <td><input name="num" type="text" size="15" value="${sm.getSOID() }" id="iorder" readonly="readonly"/></td>
    <td>创建时间</td>
    <td><input name="t4" type="text" size="15" value="${sm.getCreateTime() }" readonly="readonly"/></td>
    <td >客户名称</td>
    <td>
    	<select name="t2">
    		<c:forEach items="${alcusname }" var="cusname">
    			<option  <c:if test="${cusname eq sm.getCustomerCode()}">selected</c:if>>${cusname }
    			</option>
    		</c:forEach>
    	</select>
    
    	
     </td>
    <td>创建用户</td>
    <td>
   	 
    		<c:forEach items="${alaccount }" var="account">
    			 <c:if test="${account eq sm.getAccount()}"><input value="${account }" name="t3" readonly="readonly"></c:if>
    			
    		</c:forEach>
    	
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
    			<option  <c:if test="${sm.getPayType() eq '预付款到发货'}">selected</c:if>>预付款到发货</option>
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
 
  <tr>
  	<td colspan="8" style="text-align:center;"><input type="text" name="savechange" value="savechange" style="display: none;"> <input type="submit" value="修改"><input type="button" value="删除" onclick="delmain()"></td>
  </tr>
  </form>
  
</table>				
    	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  		<tr>
			<td nowrap class="title1">销售单明细</td>
		</tr>
	</table>			
<table id="headTable" width="100%"  border="0" align="center" class="a1" >
 	<c:forEach items="${al }" var="x">
  	<tr align="justify">
    <td>销售单编号</td>
    <td><input type="text" size="15" value="${x.getSOID() }"/></td>
    <td>产品编号</td>
    <td><input  type="text" size="15" value="${x.getProductCode() }"/></td>
    <td>产品单价</td>
    <td>
    	<input  type="text" size="15" value="${x.getUnitPrice() }"/>
    </td>
    <td>产品数量</td>
    	<td><input  type="text"  size="15" value="${x.getNum() }"/></td>
   </tr>
 
  <tr>
  	<td>数量单位</td>
  	 <td><input type="text" size="15" value="${x.getUnitName() }"/></td>
  	<td>明细总价</td>
  	<td><input type="text" size="15" value="${x.getItemPrice() }"/></td>
  	<td>删除该明细</td>
  	<td><input type="button" size="15" onclick="delitem(this)" value="删除"/><span style="display: none;">${x.getSOID() }</span><span style="display: none;">${x.getProductCode() }</span></td>
  	<td>修改该明细</td>
  	<td><input type="button" size="15" value="新增" onclick="show()"/><input type="button" size="15" value="取消" onclick="cancel()" /></td>
  </tr>
 </c:forEach>
  
</table>		
    	
 <table width="100%"  border="0" align="center" cellspacing="1" id="detailTable" style="display:none;">
  <tr>
    <td class="toolbar"> 商品编码 </td>
    <td class="toolbar"> 商品名称 </td>
    <td class="toolbar"> 产品数量 </td>
    <td class="toolbar">数量单位</td>
    <td class="toolbar">销售单价</td>
    <td class="toolbar">销售明细总价</td>
  </tr>
  <c:forEach items="${alproduct }" var="alp">
  	<tr>
  		<td><a onclick="additem(this)">${alp.getId() }</a></td>
		<td>${alp.getName() }</td>
		 <td><input type="text" name="alpnum"/></td>
		<td>${alp.getWeight() }</td>
  		<td><input type="text" name="alputiprice"/></td>
  		<td><input readonly="readonly" placeholder="自动生成无需输入"/></td>
  	</tr>
  </c:forEach>
</table>


    				
  </body>
</html>
