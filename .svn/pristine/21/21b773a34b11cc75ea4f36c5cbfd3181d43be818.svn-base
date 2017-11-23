<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>月度采购报表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/SCM/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－月度采购报表</td>
		</tr>
	</table>
	<form action="/SCM/PomainStatementServlet" method="post" class="table1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1">
		<tr>
			<td width="30px" nowrap class="toolbar" colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td align="center">年份
				<select name="year" id="year">
					<option class="year" value=""></option>
				</select>
			</td>
			<td align="center">月份
				<select name="mon" id="mon">
					<option value=""></option>
				</select>
			</td>
			<td  align="center"><input type="button" value="查询" />&nbsp;<input type="button" value="重置" /></td>
		</tr>
	</table>
	</form>
	<div class="loadText"></div>
	<c:if test="${not empty pomainSt.purchaseNum}">
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title1">采购单总数</td>
				<td class="title1">已了结数</td>
				<td class="title1">采购单总金额</td>
				<td class="title1">已付款金额</td>
			</tr>
			<tr>
				<td align="center">${pomainSt.purchaseNum}</td>
				<td align="center">${pomainSt.finishNum}</td>
				<td align="center">${pomainSt.purchaseMoney}</td>
				<td align="center">${pomainSt.paidMoney}</td>
			</tr>
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${not empty page.data}">
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title1">采购单编号</td>
				<td class="title1">供应商编号</td>
				<td class="title1">供应商名称</td>
				<td class="title1">采购日期</td>
				<td class="title1">经手人</td>
				<td class="title1">采购单总金额</td>
				<td class="title1">未付款金额</td>
				<td class="title1">采购单状态</td>
			</tr>
			<c:forEach items="${page.data}" var="p">
				<tr>
					<td align="center">${p.poid}</td>
					<td align="center">${p.venderCode}</td>
					<td align="center">${p.venderName}</td>
					<td align="center">${p.createTime}</td>
					<td align="center">${p.createUser}</td>
					<td align="center">${p.poTotal}</td>
					<td align="center">
						<c:choose>
							<c:when test="${p.payType eq '款到发货' && p.status eq 1}">${p.poTotal}</c:when>
							<c:when test="${p.payType eq '货到付款' && p.status lt 3}">${p.poTotal}</c:when>
							<c:when test="${p.payType eq '预付款到发货' && p.status eq 5}">${p.poTotal-p.prePayFee}</c:when>
							<c:when test="${p.payType eq '预付款到发货' && p.status eq 1}">${p.poTotal}</c:when>
							<c:otherwise>0.0</c:otherwise>
						</c:choose>
					</td>
					<td align="center"><c:if test="${p.status eq 1}">新增</c:if><c:if test="${p.status eq 2}">已收货</c:if><c:if test="${p.status eq 3}">已付款</c:if><c:if test="${p.status eq 4}">已了结</c:if><c:if test="${p.status eq 5}">已预付</c:if></td>
				</tr>
			</c:forEach>
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
		<div class="pageDiv" align="center">
		<c:if test="${page.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page.toTalPage ne 0}">当前第${page.nowPage}页&nbsp;&nbsp;有${page.data.size()}条记录&nbsp;&nbsp;共有${page.toTalPage}页&nbsp;&nbsp;</c:if>
		<c:if test="${page.toTalPage gt 1}"><a href="javascript:void(0)" onclick="cPage(0)">首页</a>&nbsp;&nbsp;<c:choose>
			<c:when test="${page.nowPage eq 1}"><a href="javascript:void(0)" onclick="cPage(1)">下一页</a></c:when>
			<c:when test="${page.nowPage eq page.toTalPage}"><a href="javascript:void(0)" onclick="cPage(-1)">上一页</a></c:when>
			<c:otherwise><a href="javascript:void(0)" onclick="cPage(-1)">上一页</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(1)">下一页</a></c:otherwise>
		</c:choose>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(2)">末页</a></c:if>
		</div>
	</c:if>
	<input type="hidden" value="${year}" class="y"/>
	<input type="hidden" value="${mon}" class="m"/>
	<input type="hidden" value="${page.nowPage}" name="page"/>
	<input type="hidden" value="${page.toTalPage}" name="pageT"/>
	<br />
	<br />
	<br />
	<br />
	<br />
	<script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="/SCM/script/common.js"></script>
	<script language="javascript">
		var month,year,y,m,boolean;
		$(function(){
			var time=new Date();
			year=time.getFullYear();
			month=time.getMonth();
			for(var i=year;i>=2010;i--){
				$('#year').append("<option>"+i+"</option>");
			}
			for(var i=1;i<13;i++){
				$('#mon').append("<option>"+i+"</option>");
			}
			$('#year,#mon').bind("change",function(){change();});
			$("[value=重置]").click(function(){
				$("option[value=]").attr("selected","selected");
		});
		$("[value=查询]").click(function(){
			if($("#year").val()==''){
				$("#year").focus();
			}
			else if($("#mon").val()==''){
				$("#mon").focus();
			}
			else{
				$(".table1").submit();
			}
		});
		$("#year").val($(".y").val());
		$("#mon").val($(".m").val());
		});
		function change(){
			y=$("#year option:selected").text();
			m=$("#mon option:selected").text();
			if(y==year&&m>month+1){
				alert("现在还没到"+m+"月！");
				$('#mon option:eq('+(month+1)+')').attr("selected",true);
			}	
		}
		function cPage(a){//a：0为首页，1为下一页，-1为上一页，2为末页
			 var cNum=$("[name=page]").val()-(-a);
			 if(a==2) cNum=$("[name=pageT]").val();
			 else if(a==0) cNum=1;
			 location="/SCM/PomainStatementServlet?&nowPage="+cNum+"&year="+$("[name=year]").val()+"&mon="+$("[name=mon]").val(); 
		}
		
	</script>
</body>
</html>
