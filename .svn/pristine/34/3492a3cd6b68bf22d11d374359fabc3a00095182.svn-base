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
    
    <title>新增采购单管理</title>
    
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
    <td nowrap class="title1">您的位置：工作台面－－新增采购单管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.location='/SCM/PomainBeforeAddServlet'"><img src="/SCM/images/new.gif">新增</td>  
	<td nowrap class="toolbar"></td>
    
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">采购单编号</td>
    <td class="title1">创建时间</td>
	<td class="title1">创建用户</td>
	<td class="title1">供应商</td>
    <td class="title1">附加费用</td>
    <td class="title1">产品总价</td>
    <td class="title1">采购单总价</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page.data}" var="p">
	  <tr>
	    <td align="center"><a href="/SCM/PomainShowAllServlet?poid=${p.poid}&nowPage=${page.nowPage}">${p.poid}</a></td>
	    <td align="center">${p.createTime}</td>
			<td align="center">${p.accountName}</td>
			<td align="center">${p.venderName}</td>
		  <td align="center">${p.tipFee}</td>
		  <td align="center">${p.productTotal}</td>
		  <td align="center">${p.poTotal}</td>
		  <td align="center">${p.payType}</td>
		  <td align="center">${p.prePayFee}</td>
		  <td align="center"><a class="pomainModifyA" href="javascript:void(0)">修改</a> <a class="pomainDelA" href="javascript:void(0)">删除</a></td>
	  </tr>
  </c:forEach>
  
  
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div class="pageDiv" align="center">
		<c:if test="${page.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page.toTalPage ne 0}">当前第${page.nowPage}页&nbsp;&nbsp;有${page.data.size()}条记录&nbsp;&nbsp;共有${page.toTalPage}页&nbsp;&nbsp;</c:if>
		<c:if test="${page.toTalPage gt 1}"><a href="/SCM/PomainServlet?nowPage=1">首页</a>&nbsp;&nbsp;<c:choose>
			<c:when test="${page.nowPage eq 1}"><a href="/SCM/PomainServlet?nowPage=${page.nowPage+1}">下一页</a></c:when>
			<c:when test="${page.nowPage eq page.toTalPage}"><a href="/SCM/PomainServlet?nowPage=${page.nowPage-1}">上一页</a></c:when>
			<c:otherwise><a href="/SCM/PomainServlet?nowPage=${page.nowPage-1}">上一页</a>&nbsp;&nbsp;<a href="/SCM/PomainServlet?nowPage=${page.nowPage+1}">下一页</a></c:otherwise>
		</c:choose>&nbsp;&nbsp;<a href="/SCM/PomainServlet?nowPage=${page.toTalPage}">末页</a></c:if>
		
	</div>
<br/><br/><br/><br/><br/>
 <input type="hidden" value="${page.nowPage}" name="nowPage"/>
 <input type="hidden" class="hidden" value="${Message}"/>
 
 <script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="/SCM/script/common.js"></script>
	<script language="javascript">
		$(function(){
			if($(".hidden").val()!=""){
				alert($(".hidden").val());
				$(".hidden").val("");
			}
			$(".pomainDelA").click(function(){
				if(confirm("确定删除？")){
					var poid=$(this).parent().parent().children().first().text();
					location="/SCM/PomainDelServlet?poid="+poid+"&nowPage="+$("[name=nowPage]").val();
				}
			});
			$(".pomainModifyA").click(function(){
					var poid=$(this).parent().parent().children().first().text();
					location="/SCM/PomainBeforeAddServlet?poid="+poid+"&nowPage="+$("[name=nowPage]").val();				
			});
		});
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
				$(".venderCodespan").text("");
				$(".td2").attr("width","");
				$("[name=password]").val($(obj).val());
			}	
		}
		function inputCheck(){			
			if($("[name=name]").val().length>100){
				$(".namespan").text("字符数必须小于100");
				$(".td2").attr("width","280px");
			}
			else{
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
