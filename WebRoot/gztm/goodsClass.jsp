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
    
    <title>产品分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script language="javascript" type="text/javascript">
	function re(){
		document.getElementById("m").style.display="block";
		document.getElementById("add").style.display="none";
		}
		
	function c(){
		window.location.href="gztm/addGoodsClass.jsp";
	}
	function validationDel(){
		var con=confirm("确定删除吗");
		if(con){
			return true;
		}else{
			return false;
		}
	}
	$(function(){
		$("[value=GO]").click(function(){
			var inputpage =$("[name=inputpage]").val();
			var reg=/^[0-9]+$/;
			if(reg.test(inputpage)){
				if(inputpage<1||parseInt(inputpage)>parseInt($("[name=totalpage]").val())){
					alert("输入有误,请正确输入页码");
				}else{
					window.location="SelectCategory?nowPage="+inputpage;
				}
			
			}else{
				alert("输入格式有误,请正确输入页码");
			}
		});
	
	});
	
</script>

  </head>

<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－产品分类管理</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="c()"><img
					src="images/new.gif">新增</td>
				<td width="20px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar"></td>
				<td nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td class="title1">分类序列号</td>
				<td class="title1">名称</td>
				<td class="title1">描述</td>
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${cp.dataAl }" var="gd">
				<tr>
					<td align="center">${gd.categoryID }</td>
					<td align="center">${gd.name }</td>
					<td align="center">${gd.remark }</td>
					<td align="center">
						<a href="DisplayUpdateContent?categoryID=${gd.categoryID }&name=${gd.name }&remark=${gd.remark }">修改</a> 
						<a href="DeleteCategory?categoryID=${gd.categoryID }"  onclick="return validationDel()">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:choose>
		  <c:when test="${cp.totalPage eq 0}"> 当前第0页   , 共${cp.totalPage }页</c:when>
		  <c:when test="${cp.totalPage ne 0}"> 当前第${cp.nowPage }页   , 共${cp.totalPage }页</c:when>
		</c:choose> 
    <br/>
    <a href="SelectCategory?nowPage=1">首页</a>
    <c:choose>
    	<c:when test="${cp.nowPage ==1}"> <a href="SelectCategory?nowPage=${cp.nowPage +1}">下一页</a></c:when>
    	<c:when test="${cp.nowPage ==cp.totalPage }"><a href="SelectCategory?nowPage=${cp.nowPage -1}">上一页</a></c:when>
    	<c:otherwise>
    		<a href="SelectCategory?nowPage=${cp.nowPage -1}">上一页</a>
    		<a href="SelectCategory?nowPage=${cp.nowPage +1}">下一页</a>
    	</c:otherwise>
    </c:choose>
    <a href="SelectCategory?nowPage=${cp.totalPage }">末页</a>
		<c:if test="${not empty categoryIDHasBeUsed}"><span style="margin:auto;color:red">${categoryIDHasBeUsed }</span></c:if>
	
	<input type="text" name="inputpage"  style="width:30px"/>
	<input type="button" value="GO"/>
	<input type="text" name="totalpage"  value="${cp.totalPage }" style="display:none"/>
	</div>
	

	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

</body>
</html>
