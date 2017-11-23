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
    
    <title>My JSP 'changCount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
	
	function update(){
		document.getElementById("m").style.display="none";
		document.getElementById("add").style.display="block";
		}
	function re(){
		document.getElementById("m").style.display="block";
		document.getElementById("add").style.display="none";
		}
	function stock(){
		var flag=confirm("是否要盘点");
		if(flag){
			if(document.getElementById("type").value=="损耗"){
				if(document.getElementById("ysNum").value<1||document.getElementById("num").value-document.getElementById("ysNum").value>0){
					alert("无法盘点");
					return;
				}
			
			}
			time();
			location="Stock?num="+document.getElementById("num").value+"&type="+document.getElementById("type").value+"&reason="+document.getElementById("reason").value+"&productCode="+document.getElementById("productCode").value+"&ysNum="+document.getElementById("ysNum").value+"&time="+document.getElementById("time").value+"&people="+document.getElementById("people").value;
			//xl="+document.getElementById("xl").value？？？？？？？？？？;
		}
	}	
	function time() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month<10) month="0"+month;
		var day = date.getDate();
		if(day<10) day="0"+day;
		var house = date.getHours();
		if(house<10) house="0"+house;
		var minutes = date.getMinutes();
		if(minutes<10) minutes="0"+minutes;
		var second = date.getSeconds();
		if(second<10) second="0"+second;
		//var milsecond = date.getMilliseconds();
		document.getElementById("time").value = year + "-" + month
				+ "-" + day + " " + house + ":" + minutes + ":" + second;
	}	
</script>

  </head>
  
  <body>
    <div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－盘点管理</td>
  </tr>
</table>

<div id="add">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<tr>
    <td class="title1">产品编号</td>
    <td class="title1"><input type="text" value="${productCode}" id="productCode" readonly="readonly"></td>
	</tr>
	<tr>
    <td class="title1">原始数量</td>
    <td class="title1"><input type="text" id="ysNum" value="${ysNum }" readonly="readonly"></td>
	</tr>
  <tr>
    <td class="title1">变化数量</td>
    <td class="title1"><input type="text" id="num"></td>
	</tr>
  <tr>
  <!--<tr>
    <td class="title1">盘点时间</td>
    <td class="title1"><input type="text" id="time"></td>
	</tr>-->
	<input type="hidden" id="time"/>
  <tr>
  <tr>
    <td class="title1">经手人</td>
    <td class="title1"><input type="text" id="people" value="${name}" readonly="readonly"></td>
	</tr>
  <tr>
    <td align="center" >变化类型</td>
    <td align="center">
		<select id="type">
			<option>损耗</option>
			<option>盈余</option>
		</select>
	</td>
	</tr>
  <tr>
    <td align="center">原因</td>
    <td align="center">
    	<input name="jzrq" id="reason" type="text" size="15">
    </td>
	</tr>
  <tr>
  	<td colspan="2" align="center"><input type="button" value="盘点" onclick="stock()"/></td>
  </tr>
</table>
</div>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

  </body>
</html>
