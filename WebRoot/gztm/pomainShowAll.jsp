<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>采购单详细显示</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="/SCM/css/style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
			div.product{
				position: absolute;
				top:2px;
				left: 2px;
				width:100%;
				height: 98%;
				background-color: #fffffe;
				
			}
		
		</style>
  </head>
  
  <body>
	
		<div class="formVisiblitly" id="formDiv"></div>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td nowrap class="toolbar">&nbsp;</td>
			  </tr>
			</table>
			
			<table id="headTable" width="100%"  border="0" align="center" class="a1">
			  <tr align="justify">
			    <td>采购单编号</td>
			    <td><input readonly  type="text" readonly size="15"  value="${pomain.poid}"/>
			      </td>
			    <td>创建时间</td>
			    <td><input readonly  type="text" size="15"  readonly value="${pomain.createTime}"/></td>
			    <td>供应商名称</td>
			    <td><input readonly  type="text" size="15" value="${pomain.venderName}" /></td>
			     <td>供应商编号</td>
			   	<td><input readonly  type="text" size="15" value="${pomain.venderCode}"/>
			   	</td> 
			  </tr>
			  <tr align="justify">
			  	<td>创建用户</td>
			    <td><input readonly  type="text" size="15" value="${pomain.accountName}"/></td>
			    <td>附加费用</td>
			    <td><input readonly  type="text" value="${pomain.tipFee}" size="15" />
			      </td>
			    <td>采购产品总价</td>
			    <td><input readonly  type="text" size="15" value="${pomain.productTotal}"/></td>
			    <td>付款方式</td>
			    <td><input readonly  type="text" size="15" value="${pomain.payType}">
			    </td>
			  </tr>
			  <tr align="justify">
			  	 <td>预付款金额</td>
			    <td><input readonly  type="text" value="${pomain.prePayFee}" size="15"/>
			      </td>
			    <td>采购单总价</td>
			    <td><input readonly  type="text" size="15" value="${pomain.poTotal}">
			    </td>			   
			     <td>处理状态</td>
			    <td><input readonly   type="text" size="15" <c:if test="${pomain.status eq 1}">value="新增"</c:if><c:if test="${pomain.status eq 2}">value="已收货"</c:if><c:if test="${pomain.status eq 3}">value="已付款"</c:if><c:if test="${pomain.status eq 4}">value="已了结"</c:if><c:if test="${pomain.status eq 5}">value="已预付"</c:if>/>
			    </td>
			     <td>备注</td>
			    <td><input readonly   type="text" size="15" value="${pomain.remark}"/>
			    </td>  
			  </tr>
			  <tr align="justify">
			  	<td>入库登记时间</td>
			    <td><input readonly  type="text" size="15" value="${pomain.stockTime}">
			    </td>
			   <td>入库登记用户</td>
			    <td><input readonly  type="text" size="15" value="${pomain.stockUser}"/></td>
			     <td>付款登记时间</td>
			    <td><input readonly   type="text" size="15" value="${pomain.payTime}"/>
			    </td>
			     <td>付款登记用户</td>
			    <td><input readonly   type="text" size="15" value="${pomain.payUser}"/>
			    </td>  
			  </tr>
			  <tr align="justify">
			  	<td>预付登记时间</td>
			    <td><input readonly  type="text" size="15" value="${pomain.prePayTime}">
			    </td>
			   <td>预付登记用户</td>
			    <td><input readonly  type="text" size="15" value="${pomain.prePayUser}"/></td>
			     <td>了结时间</td>
			    <td><input readonly   type="text" size="15" value="${pomain.endTime}"/>
			    </td>
			     <td>了结用户</td>
			    <td><input readonly   type="text" size="15" value="${pomain.endUser}"/>
			    </td>  
			  </tr>
			</table>
			
			<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
			  <tr>
			    <td class="toolbar"> 序号 </td>
			    <td class="toolbar">产品编码 </td>
			    <td class="toolbar">产品名称 </td>
			    <td class="toolbar">数量单位</td>
			    <td class="toolbar">产品数量 </td>
			    <td class="toolbar">采购单价</td>
			    <td class="toolbar">明细总价</td>
			  </tr>
				<c:forEach items="${poitem}" var="p" varStatus="i"><tr align="center">  
					  <td>${i.index+1}</td>
					  <td><input value="${p.productCode}" type="text"  size="10" readonly></td>
						<td><input value="${p.productName}" type="text" size="15" readonly></td>
						<td><input value="${p.unitName}" type="text"  size="10" readonly></td>
						<td><input value="${p.num}" type="text" size="10" readonly></td>
						<td><input value="${p.unitPrice}" type="text" size="10" readonly></td>
						<td><input value="${p.itemPrice}" type="text" size="10" readonly></td>
			  </tr></c:forEach>
			</table>
			<table width="100%"  border="0" align="center" cellspacing="1">
			  <tr>
			    <td class="title2"></td>
			  </tr>
			</table>
			<br/>
			<div align="center">
			    <input readonly  class="return" type="button" value="返回" >
			</div>
			 <input type="hidden" value="${nowPage}" name="nowPage"/>
			 <input type="hidden" value="${page1}" name="page1"/>
	 		 <input type="hidden" value="${page2}" name="page2"/>
	 		 <input type="hidden" value="${page3}" name="page3"/>
	 		 <input type="hidden" value="${search}" name="search"/>
	 		 <input type="hidden" value="${pomainSearch.poidPart}" name="poidPart"/>
	 		 <input type="hidden" value="${pomainSearch.timeStart}" name="timeStart"/>
	 		 <input type="hidden" value="${pomainSearch.timeEnd}" name="timeEnd"/>
			<input type="hidden" value="${pomainSearch.venderName}" name="venderName"/>
			<input type="hidden" value="${pomainSearch.venderCode}" name="venderCode"/>
			<input type="hidden" value="${pomainSearch.payType}" name="payType"/>
			<input type="hidden" value="${pomainSearch.status}" name="status"/>
			<script language="javascript" src="/SCM/script/jquery-1.8.1.min.js" ></script>
			<script language="javascript" >
				$(function(){
					$(".return").click(function(){
							var poid=$(this).parent().parent().children().first().text();
							if($("[name=search]").val()==""){
								if($("[name=nowPage]").val()=="")
									location="/SCM/PomainGetPreFinishServlet?poid="+poid+"&page1="+$("[name=page1]").val()+"&page2="+$("[name=page2]").val()+"&page3="+$("[name=page3]").val();
								else 
									location="/SCM/PomainServlet?poid="+poid+"&nowPage="+$("[name=nowPage]").val();
							}
							else
								location="/SCM/PomainSearchServlet?nowPage="+$("[name=nowPage]").val()+"&poidPart="+$("[name=poidPart]").val()+"&timeStart="+$("[name=timeStart]").val()+"&timeEnd="+$("[name=timeEnd]").val()+"&venderName="+$("[name=venderName]").val()+"&venderCode="+$("[name=venderCode]").val()+"&payType="+$("[name=payType]").val()+"&status="+$("[name=status]").val();
					});
				});
				
			</script>
			
			
			
	
	</body>
</html>
