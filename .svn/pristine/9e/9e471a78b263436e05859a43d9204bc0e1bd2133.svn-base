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

<title>月度出库报表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script type="text/javascript" src="script/productDiv.js"></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script language="javascript" type="text/javascript">
	function displayDate(){
		var year=document.getElementById("year");
		var month=document.getElementById("month");
		for(var i=2010;i<=2017;i++){
			var newOption=document.createElement("option");
			year.appendChild(newOption);
			newOption.innerHTML=i;
			if(i==2017){
				newOption.selected="selected";
			}
		}
		for(var i=1;i<=12;i++){
			var newOption=document.createElement("option");
			month.appendChild(newOption);
			if(i<10){
				newOption.innerHTML="0"+i;			
			}else{
				newOption.innerHTML=i;
			}
			if(i==1){
				newOption.selected="selected";
			}
		}
	}
	
	function query1(){
		var year= document.getElementById("year").value;
		var month=document.getElementById("month").value;
		var ci=document.getElementById("ci");
		var num=document.getElementById("num");
		var price=document.getElementById("price");
		var tab=document.getElementById("detialTab");
		var len=tab.rows.length;
		for(var j=1;j<len-2;j++){
			tab.deleteRow(3);
		}
		$.get("Month_Outstock_Form",
			{"year":year,"month":month},
			function(data){
				var arr=data.split("!");
				for(var i=0;i<arr.length;i++){
					var res= eval("("+arr[i]+")");
					if(i==0){
						ci.innerHTML=res;
					}else if(i==1){
						num.innerHTML=res;
					}else if(i==2){
						price.innerHTML=res;
					}else if(i==3){
						
						for(var j=0;j<res.length;j++){
							var row=tab.insertRow(-1);
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].orderCode;
							cell.align="center";
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].stockTime;
							cell.align="center";
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].productCode;
							cell.align="center";
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].productName;
							cell.align="center";
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].stockNum;
							cell.align="center";
							var cell=row.insertCell(-1);
							cell.innerHTML=res[j].productPrice;
							cell.align="center";
							
						}
					}
				}
			}
		
		);
	}
</script>
</head>

<body onload="displayDate()">
	<div id="m">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－月度出库报表</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar"></td>
			<td width="20px" nowrap class="toolbar"></td>
			<td width="40px" nowrap class="toolbar"></td>
			<td nowrap class="toolbar"></td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellspacing="1" class="c" id="detialTab">
		<tr>
			<td class="title1">出库单据数：<span id="ci"></span></td>
			<td class="title1">产品总数量：<span id="num"></span></td>
			<td class="title1" colspan="4">出库产品总金额：<span id="price"></span></td>

		</tr>
		<tr style="height:10px"><td class="title1" colspan="6"><hr/></td></tr>
		<tr>
			<td class="title1">销售单号</td>
			<td class="title1">入库日期</td>
			<td class="title1">产品编号</td>
			<td class="title1">产品名称</td>
			<td class="title1">产品数</td>
			<td class="title1">产品总金额</td>
		</tr>
		<%-- <c:forEach items="${alOutstockRecord }" var="gd">
			<tr>
				<td align="center">${gd.orderCode }</td>
				<td align="center">${gd.stockTime }</td>
				<td align="center">${gd.productCode }</td>
				<td align="center">${gd.productName}</td>
				<td align="center">${gd.stockNum }</td>
				<td align="center">${gd.productPrice }</td>
			</tr>
		</c:forEach> --%>
		
		
	</table>
	<!-- <form action="Month_Outstock_Form" method="get"> -->
		<select id="year" name="year"></select>
		<select id="month" name="month"></select>
		<input type="button" value="查询" onclick="query1()">
	<!-- </form> -->
	</div>

	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

</body>
</html>
