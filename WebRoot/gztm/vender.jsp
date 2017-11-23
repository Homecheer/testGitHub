﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.addVenderDiv{display:none;}
		span{color:#FF0000;}
		.pageDiv{width:350px;margin:auto;}
	</style>
	
  </head>
  
  <body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－供应商管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="showAddVender()"><img src="/SCM/images/new.gif">新增</td>
    
    
	<td nowrap class="toolbar"></td>
    
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">供应商编号</td>
    <td class="title1">供应商名称</td>
	<td class="title1">联系人</td>
	<td class="title1">地址</td>
    <td class="title1">邮政编码</td>
    <td class="title1">注册日期</td>
    <td class="title1">电话</td>
    <td class="title1">传真</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page.data}" var="v">
	  <tr>
	    <td align="center">${v.venderCode}</td>
	    <td align="center">${v.name}</td>
			<td align="center">${v.contactor}</td>
			<td align="center">${v.address}</td>
		  <td align="center">${v.postcode}</td>
		  <td align="center">${v.createDate}</td>
		  <td align="center">${v.tel}</td>
		  <td align="center">${v.fax}</td>
		  <td align="center"><a class="venderModifyA" href="javascript:void(0)">修改</a> <a class="venderDelA" href="javascript:void(0)">删除</a></td>
	  </tr>
  </c:forEach>
  
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div class="pageDiv" align="center">
	<c:if test="${page.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page.toTalPage ne 0}">当前第${page.nowPage}页&nbsp;&nbsp;有${page.data.size()}条记录&nbsp;&nbsp;共有${page.toTalPage}页&nbsp;&nbsp;</c:if>
	<c:if test="${page.toTalPage gt 1}"><a href="/SCM/VenderServlet?nowPage=1">首页</a>&nbsp;&nbsp;<c:choose>
		<c:when test="${page.nowPage eq 1}"><a href="/SCM/VenderServlet?nowPage=${page.nowPage+1}">下一页</a></c:when>
		<c:when test="${page.nowPage eq page.toTalPage}"><a href="/SCM/VenderServlet?nowPage=${page.nowPage-1}">上一页</a></c:when>
		<c:otherwise><a href="/SCM/VenderServlet?nowPage=${page.nowPage-1}">上一页</a>&nbsp;&nbsp;<a href="/SCM/VenderServlet?nowPage=${page.nowPage+1}">下一页</a></c:otherwise>
	</c:choose>&nbsp;&nbsp;<a href="/SCM/VenderServlet?nowPage=${page.toTalPage}">末页</a></c:if>
	
</div>
<br/><br/><br/><br/><br/>
<div class="addVenderDiv"<c:if test="${not empty getAddVender}">style="display:block"</c:if> >
  <form class="venderAddForm" method="post" <c:if test="${not empty getModifyVender}">action="/SCM/VenderModifyServlet"</c:if><c:if test="${empty getModifyVender}">action="/SCM/VenderAddServlet"</c:if>>
	  <table cellspancing="0" border="1" align="center">
	  <!-- <c:if test="${not empty getAddVender && empty getModifyVender}">已有该供应商编号</c:if> -->
	  	<tr><td class="td1">供应商编号:</td><td class="td2"><input type="text" name="venderCode" required <c:if test="${not empty getModifyVender}">readonly</c:if> onblur="synPW(this)" <c:if test="${not empty getAddVender}">value="${getAddVender.venderCode}"</c:if>/><span class="venderCodespan"></span></td></tr>
	  		<tr><td class="td1">供应商姓名:</td><td class="td2"><input type="text" name="name" required  oninput="inputCheck()" onblur="inputBlur(this)" <c:if test="${not empty getAddVender}">value="${getAddVender.name}"</c:if>/><span class="namespan"></span></td></tr>
	  		<tr><td class="td1">供应商密码:</td><td class="td2"><input type="password" name="password" <c:if test="${not empty getAddVender}">value="${getAddVender.password}"</c:if>/></td></tr>
	  		<tr><td class="td1">联系人:</td><td class="td2"><input type="text" name="contactor" required oninput="inputCheck()" <c:if test="${not empty getAddVender}">value="${getAddVender.contactor}"</c:if>/><span class="contactorspan"></span></td></tr>
	  		<tr><td class="td1">地址:</td><td class="td2"><input type="text" name="address" <c:if test="${not empty getAddVender}">value="${getAddVender.address}"</c:if>/></td></tr>
	  		<tr><td class="td1">邮政编码:</td><td class="td2"><input type="text" name="postcode" <c:if test="${not empty getAddVender}">value="${getAddVender.postcode}"</c:if>/></td></tr>
	  		<tr><td class="td1">注册日期:</td><td class="td2"><input type="text" readonly name="createDate" <c:if test="${not empty getAddVender}">value="${getAddVender.createDate}"</c:if>/></td></tr>
	  		<tr><td class="td1">电话:</td><td class="td2"><input type="text" name="tel" required oninput="inputCheck()" <c:if test="${not empty getAddVender}">value="${getAddVender.tel}"</c:if>/><span class="telspan"></span></td></tr>
	  		<tr><td class="td1">传真:</td><td class="td2"><input type="text" name="fax" <c:if test="${not empty getAddVender}">value="${getAddVender.fax}"</c:if>/></td></tr>
	  		<tr><td><input type="button" value="保存" onclick="save()"/></td><td><input type="button" value="取消" onclick="hiddenAddVender()"></td></tr>
	  </table>
	  <input type="hidden" value="${page.nowPage}" name="nowPage"/>
  </form>
 </div> <input type="hidden" class="hidden" value="${Message}"/>
 
 <script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="script/common.js"></script>
	<script language="javascript">
		$(function(){
			if($(".hidden").val()!=""){
				alert($(".hidden").val());
				$(".hidden").val("");
			}
			$(".venderDelA").click(function(){
				if(confirm("确定删除？")){
					var venderCode=$(this).parent().parent().children().first().text();
					location="/SCM/VenderDelServlet?venderCode="+venderCode+"&nowPage="+$("[name=nowPage]").val();
				}
			});
			$(".venderModifyA").click(function(){
					$(".venderAddForm").attr("action","/SCM/VenderModifyServlet");
					var venderCode=$(this).parent().parent().children().first().text();
					location="/SCM/VenderGetModifyServlet?venderCode="+venderCode+"&nowPage="+$("[name=nowPage]").val();				
			});
			$("[name=venderCode]").bind(
				{"input":function(){checkVenderCode(this);},"keyup":function(){checkVenderCode(this);}}
			);
		});
		function checkVenderCode(obj){
			if(!$(obj).attr("readonly"))	
				$.get("/SCM/VenderAddServlet","venderCode="+$(obj).val(),function(data){$("[name=password]").val("");$(".venderCodespan").text(data);if($(".venderCodespan").text()=="") $(".td2").attr("width","");},"text");
		}
		function showAddVender(){
			$(".venderAddForm").attr("action","/SCM/VenderAddServlet");
			hiddenAddVender();
			var date=new Date();
			$("[name=venderCode]").attr("readonly",false);
			$("[name=createDate]").attr("value",date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
			$(".addVenderDiv").css("display","block");
		}
		function hiddenAddVender(){
			$(".addVenderDiv").css("display","none");
			$(".addVenderDiv .td2 input").attr("value","");
			$("span").text("");
			$(".td2").attr("width","");
		}
		function synPW(obj){
			var venderCodeReg=/^[0-9a-zA-Z]{4,20}$/;
			if(!venderCodeReg.test($("[name=venderCode]").val())){
				$(".venderCodespan").text("字母和数字(4-20个字符)");
				$(".td2").attr("width","305px");
				$("[name=password]").val("");
			}
			else{
					if($(".venderCodespan").text()==""){
						//$(".td2").attr("width","");
						$("[name=password]").val($(obj).val());
					}
			}	
			inputBlur(obj);
		}
		function inputCheck(){			
			if($("[name=name]").val().length>100){
				$(".namespan").text("字符数必须小于100");
				$(".td2").attr("width","280px");
			}
			else if($("[name=name]").val().length!=0){
				$(".namespan").text("");	
			}
			if($("[name=contactor]").val()!=""){
				$(".contactorspan").text("");
			}
			if($("[name=tel]").val()!=""){
				$(".telspan").text("");
			}
			$(".td2").attr("width","");
		}
		function inputBlur(obj){
			if($(obj).next().text()!=""){
				$(obj).focus();
			}	
		}
		var arr=["venderCode","name","contactor","tel"];
		function save(){
			for(var i=0;i<arr.length;i++){
				if($("[name="+arr[i]+"]").val()==""){
					$("."+arr[i]+"span").text("不能为空");
				}
			}
			if($("span").text()==""){
				//$("[name=createDate]").attr("disabled",false);
				$(".venderAddForm").submit();
			}
		}
		
	</script>
</body>
</html>
