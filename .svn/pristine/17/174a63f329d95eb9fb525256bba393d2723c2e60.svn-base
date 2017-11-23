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
    
    <title>库存查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js" ></script>
<script language="javascript" type="text/javascript">

	function query(){
		var productCode =document.getElementsByName("productCode")[0].value;
		var productName =document.getElementsByName("productName")[0].value;
		var num_Min =document.getElementsByName("num_Min")[0].value;
		var num_Max =document.getElementsByName("num_Max")[0].value;
		$.get("/SCM/SelectStockByConditions",
				{"productCode":productCode,"productName":productName,"num_Min":num_Min,"num_Max":num_Max},	
				function(data){
					var arr=eval("("+data+")");
					var tab=document.getElementById("detailTab");
					var len=tab.rows.length;
					for(var i=1;i<len;i++){
						tab.deleteRow(1);
					}
					for(var i=0;i<arr.length;i++){
						var row =tab.insertRow(-1);
						var cell=row.insertCell(-1);
						var aElement=document.createElement("a");
						cell.appendChild(aElement);
						aElement.innerHTML=arr[i].productCode;
						aElement.href="StockChangeRecord?productCode="+arr[i].productCode;
						cell.align="center";
						var cell=row.insertCell(-1);
						cell.innerHTML=arr[i].name;
						cell.align="center";
						var cell=row.insertCell(-1);
						cell.innerHTML=arr[i].num;
						cell.align="center";
						var cell=row.insertCell(-1);
						cell.innerHTML=arr[i].poNum;
						cell.align="center";
						var cell=row.insertCell(-1);
						cell.innerHTML=arr[i].soNum;
						cell.align="center";
					}
				}
		);
	}
</script>

  </head>
  
  <body>
    <div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－库存查询</td>
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
		<!-- <form action="/SCM/SelectStockByConditions" method="get"> -->
			<table width="100%" border="0" align="center" cellspacing="1"
				class="c">
				<tr><td class="title1" colspan="4"><span>查询：</span></td></tr>
				<tr>
					<td class="title1">产品编号</td>
					<td class="title1">产品名称</td>
					<td class="title1">库存数量范围</td>
					<td class="title1">操作</td>
				</tr>
				<tr>
					<td align="center"><input type="text" name="productCode"></td>
					<td align="center"><input type="text" name="productName"></td>
					<td align="center">最小值<input type="text" name="num_Min">&nbsp;&nbsp;&nbsp;最大值<input type="text" name="num_Max"></td>
					<td align="center"><input type="button" value="查询" onclick="query()"/></td>
				</tr>
			</table>
		<!-- </form> -->
			<table width="100%" border="0" align="center" cellspacing="1"
				class="c" id="detailTab">
				<tr>
					<td class="title1">产品编号</td>
					<td class="title1">产品名称</td>
					<td class="title1">库存数量</td>
					<td class="title1">采购在途数</td>
					<td class="title1">销售在途数</td>

				</tr>
			 <c:forEach items="${al }" var="gd">

				<tr>
					<td align="center"><a href="StockChangeRecord?productCode=${gd.productCode }">${gd.productCode }</a></td>
					<td align="center">${gd.name }</td>
					<td align="center">${gd.num }</td>
					<td align="center">${gd.poNum }</td>
					<td align="center">${gd.soNum }</td>
				</tr>
			</c:forEach> 
			
		</table><br/><br/>
		
	</div>
  </body>
</html>
