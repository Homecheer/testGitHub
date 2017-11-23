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
    
    <title>采购单了结</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="/SCM/css/style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.addVenderDiv{display:none;}
		span{color:#FF0000;}
		.pageDiv{width:350px;margin:auto;}
		.toolbar1{background-image:url(/SCM/images/toolbar.gif); height:30px;font-size:15px;color:#0000FF;padding-left:30px;vertical-align:middle}
	</style>
	
  </head>
  
  <body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－采购单了结</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td  class="toolbar1" >货到付款</td>
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
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page1.data}" var="p">
	  <tr>
	    <td align="center"><a href="javascript:void(0)" onclick="detailShow(this)">${p.poid}</a></td>
	    <td align="center">${p.createTime}</td>
			<td align="center">${p.accountName}</td>
			<td align="center">${p.venderName}</td>
		  <td align="center">${p.tipFee}</td>
		  <td align="center">${p.productTotal}</td>
		  <td align="center">${p.poTotal}</td>
		  <td align="center">${p.payType}</td>
		  <td align="center">${p.prePayFee}</td>
		   <td align="center">
	  		<c:if test="${p.status eq 2}">已收货</c:if>
	  		<c:if test="${p.status eq 3}">已付款</c:if>
	  		<c:if test="${p.status eq 5}">已预付</c:if>
		  </td>
		  <td align="center"><a class="pomainFinishA" href="javascript:void(0)">了结</a></td>
	  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div class="pageDiv" align="center">
		<c:if test="${page1.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page1.toTalPage ne 0}">当前第${page1.nowPage}页&nbsp;&nbsp;有${page1.data.size()}条记录&nbsp;&nbsp;共有${page1.toTalPage}页&nbsp;&nbsp;</c:if>
		<c:if test="${page1.toTalPage gt 1}"><a href="javascript:void(0)" onclick="cPage(1,0)">首页</a>&nbsp;&nbsp;<c:choose>
			<c:when test="${page1.nowPage eq 1}"><a href="javascript:void(0)" onclick="cPage(1,1)">下一页</a></c:when>
			<c:when test="${page1.nowPage eq page1.toTalPage}"><a href="javascript:void(0)" onclick="cPage(1,-1)">上一页</a></c:when>
			<c:otherwise><a href="javascript:void(0)" onclick="cPage(1,-1)">上一页</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(1,1)">下一页</a></c:otherwise>
		</c:choose>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(1,2)">末页</a></c:if>	
</div><br/>

<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td  class="toolbar1" >款到发货</td>
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
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page2.data}" var="p">
	  <tr>
	    <td align="center"><a href="javascript:void(0)" onclick="detailShow(this)">${p.poid}</a></td>
	    <td align="center">${p.createTime}</td>
			<td align="center">${p.accountName}</td>
			<td align="center">${p.venderName}</td>
		  <td align="center">${p.tipFee}</td>
		  <td align="center">${p.productTotal}</td>
		  <td align="center">${p.poTotal}</td>
		  <td align="center">${p.payType}</td>
		  <td align="center">${p.prePayFee}</td>
		  <td align="center">
	  		<c:if test="${p.status eq 2}">已收货</c:if>
	  		<c:if test="${p.status eq 3}">已付款</c:if>
	  		<c:if test="${p.status eq 5}">已预付</c:if>
		  </td>
		  <td align="center"><a class="pomainFinishA" href="javascript:void(0)">了结</a></td>
	  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div class="pageDiv" align="center">
		<c:if test="${page2.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page2.toTalPage ne 0}">当前第${page2.nowPage}页&nbsp;&nbsp;有${page2.data.size()}条记录&nbsp;&nbsp;共有${page2.toTalPage}页&nbsp;&nbsp;</c:if>
		<c:if test="${page2.toTalPage gt 1}"><a href="javascript:void(0)" onclick="cPage(2,0)">首页</a>&nbsp;&nbsp;<c:choose>
			<c:when test="${page2.nowPage eq 1}"><a href="javascript:void(0)" onclick="cPage(2,1)">下一页</a></c:when>
			<c:when test="${page2.nowPage eq page2.toTalPage}"><a href="javascript:void(0)" onclick="cPage(2,-1)">上一页</a></c:when>
			<c:otherwise><a href="javascript:void(0)" onclick="cPage(2,-1)">上一页</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(2,1)">下一页</a></c:otherwise>
		</c:choose>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(2,2)">末页</a></c:if>	
</div><br/>

<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td  class="toolbar1" >预付款到发货</td>
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
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page3.data}" var="p">
	  <tr>
	    <td align="center"><a href="javascript:void(0)" onclick="detailShow(this)">${p.poid}</a></td>
	    <td align="center">${p.createTime}</td>
			<td align="center">${p.accountName}</td>
			<td align="center">${p.venderName}</td>
		  <td align="center">${p.tipFee}</td>
		  <td align="center">${p.productTotal}</td>
		  <td align="center">${p.poTotal}</td>
		  <td align="center">${p.payType}</td>
		  <td align="center">${p.prePayFee}</td>
		  <td align="center">
	  		<c:if test="${p.status eq 2}">已收货</c:if>
	  		<c:if test="${p.status eq 3}">已付款</c:if>
	  		<c:if test="${p.status eq 5}">已预付</c:if>
		  </td>
		  <td align="center"><a class="pomainFinishA" href="javascript:void(0)">了结</a></td>
	  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div class="pageDiv" align="center">
		<c:if test="${page3.toTalPage eq 0}">当前第0页&nbsp;&nbsp;有0条记录&nbsp;&nbsp;共有0页&nbsp;&nbsp;</c:if>
		<c:if test="${page3.toTalPage ne 0}">当前第${page3.nowPage}页&nbsp;&nbsp;有${page3.data.size()}条记录&nbsp;&nbsp;共有${page3.toTalPage}页&nbsp;&nbsp;</c:if>
		<c:if test="${page3.toTalPage gt 1}"><a href="javascript:void(0)" onclick="cPage(3,0)">首页</a>&nbsp;&nbsp;<c:choose>
			<c:when test="${page3.nowPage eq 1}"><a href="javascript:void(0)" onclick="cPage(3,1)">下一页</a></c:when>
			<c:when test="${page3.nowPage eq page3.toTalPage}"><a href="javascript:void(0)" onclick="cPage(3,-1)">上一页</a></c:when>
			<c:otherwise><a href="javascript:void(0)" onclick="cPage(3,-1)">上一页</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(3,1)">下一页</a></c:otherwise>
		</c:choose>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="cPage(3,2)">末页</a></c:if>	
</div><br/>

<br/><br/><br/><br/><br/>
<div class="addVenderDiv"<c:if test="${not empty getAddVender}">style="display:block"</c:if> >
  
	  <input type="hidden" value="${page1.nowPage}" name="page1"/>
	  <input type="hidden" value="${page2.nowPage}" name="page2"/>
	  <input type="hidden" value="${page3.nowPage}" name="page3"/>
	  <input type="hidden" value="${page1.toTalPage}" name="page1T"/>
	  <input type="hidden" value="${page2.toTalPage}" name="page2T"/>
	  <input type="hidden" value="${page3.toTalPage}" name="page3T"/>
 
 </div> <input type="hidden" class="hidden" value="${Message}"/>
 
 <script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="/SCM/script/common.js"></script>
	<script language="javascript">
		$(function(){
			if($(".hidden").val()!=""){
				alert($(".hidden").val());
				$(".hidden").val("");
			}
			$(".pomainFinishA").click(function(){
				if(confirm("确定了结？")){
					var poid=$(this).parent().parent().children().first().text();
					location="/SCM/PomainFinishServlet?poid="+poid+"&page1="+$("[name=page1]").val()+"&page2="+$("[name=page2]").val()+"&page3="+$("[name=page3]").val();
				}
			});
		});
		
		function cPage(i,a){//a：0为首页，1为下一页，-1为上一页，2为末页
			 var numI=i;
			 var numII=(i+1)%3==0?3:(i+1)%3;
			 var numIII=(i+2)%3==0?3:(i+2)%3;
			 var cNum=$("[name=page"+numI+"]").val()-(-a);
			 if(a==2) cNum=$("[name=page"+numI+"T]").val();
			 else if(a==0) cNum=1;
			 location="/SCM/PomainGetPreFinishServlet?page"+numI+"="+cNum+"&page"+numII+"="+$("[name=page"+numII+"]").val()+"&page"+numIII+"="+$("[name=page"+numIII+"]").val(); 
		}
		function detailShow(obj){
			var poid=$(obj).parent().parent().children().first().text();
			location="/SCM/PomainShowAllServlet?poid="+poid+"&page1="+$("[name=page1]").val()+"&page2="+$("[name=page2]").val()+"&page3="+$("[name=page3]").val();
		}
	</script>
</body>
</html>
