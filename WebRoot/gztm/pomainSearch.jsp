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

<title>采购单查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/SCM/css/style.css" rel="stylesheet" type="text/css">
<link type="text/css" href="/SCM/css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
<link type="text/css" href="/SCM/css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
<style type="text/css">
div.product {
	position: absolute;
	top: 2px;
	left: 0px;
	width: 100%;
	height: 98%;
	background-color: #fffffe;
}
</style>

</head>

<body>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－采购单查询</td>
		</tr>
	</table>
	<form action="/SCM/PomainSearchServlet" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="1">
		<tr>
			<td width="30px" nowrap class="toolbar" colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td align="center">采购单编号<input type="text" size="15" name="poidPart" 
			<c:if test="${not empty pomainSearch}">value="${pomainSearch.poidPart}"</c:if><c:if test="${empty pomainSearch}">value=""</c:if> />
			</td>
			<td align="center">开始日期<input type="text" size="15" name="timeStart" class="ui_timepicker" onblur="dateTest(this)"
			<c:if test="${not empty pomainSearch}">value="${pomainSearch.timeStart}"</c:if><c:if test="${empty pomainSearch}">value=""</c:if> />
			<a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.timeStart);return false;">
      <img name="popcal"  src="/SCM/images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
			</td>
			<td align="center">截止日期<input type="text" size="15" name="timeEnd" class="ui_timepicker" onblur="dateTest(this)"
			<c:if test="${not empty pomainSearch}">value="${pomainSearch.timeEnd}"</c:if><c:if test="${empty pomainSearch}">value=""</c:if>/>
			<a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.timeEnd);return false;">
      <img name="popcal"  src="/SCM/images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
			</td>
		</tr>
		<tr>
			<td align="center">供应商
			<input type="text" size="15" name="venderName" oninput="color(this)" onblur="color1()"
			<c:if test="${not empty pomainSearch}">value="${pomainSearch.venderName}"</c:if><c:if test="${empty pomainSearch}">value=""</c:if>/>
			<input type="hidden" size="15" name="venderCode" 
			<c:if test="${not empty pomainSearch}">value="${pomainSearch.venderCode}"</c:if><c:if test="${empty pomainSearch}">value=""</c:if>/>
			<span class="LL"><image src="/SCM/images/selectDate.gif" onClick="choiceSpxx(${AllVenders.size()-1},'venderDiv')">
			</span></td>
			<td align="center">付款方式 <select name="payType">
					<option value="" <c:if test="${empty pomainSearch}">selected</c:if>></option>
					<option value="货到付款" <c:if test="${not empty pomainSearch && pomainSearch.payType eq '货到付款'}">selected</c:if>>货到付款</option>
					<option value="款到发货" <c:if test="${not empty pomainSearch && pomainSearch.payType eq '款到发货'}">selected</c:if> >款到发货</option>
					<option value="预付款到发货" <c:if test="${not empty pomainSearch && pomainSearch.payType eq '预付款到发货'}">selected</c:if>>预付款到发货</option>
			</select></td>
			<td align="center">处理状态
				<select name="status">
					<option value="" <c:if test="${empty pomainSearch}">selected</c:if>></option>
					<option value="1" <c:if test="${not empty pomainSearch && pomainSearch.status eq '1'}">selected</c:if>>新增</option>
					<option value="2" <c:if test="${not empty pomainSearch && pomainSearch.status eq '2'}">selected</c:if>>已收货</option>
					<option value="3" <c:if test="${not empty pomainSearch && pomainSearch.status eq '3'}">selected</c:if>>已付款</option>
					<option value="4" <c:if test="${not empty pomainSearch && pomainSearch.status eq '4'}">selected</c:if>>已了结</option>
					<option value="5" <c:if test="${not empty pomainSearch && pomainSearch.status eq '5'}">selected</c:if>>已预付</option>
				</select>
			</td>
		</tr>
		<tr><td colspan="3" align="center"><input type="button" value="查询" />&nbsp;<input type="button" value="重置" /></td></tr>

	</table>
	</form>
	<c:if test="${not empty page}">
		<table width="100%" border="0" align="center" cellspacing="1">
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
			</tr>	
		<c:forEach items="${page.data}" var="p">
			<tr>
				<td align="center"><a
					href="/SCM/PomainShowAllServlet?poid=${p.poid}&poidPart=${pomainSearch.poidPart}&timeStart=${pomainSearch.timeStart}&timeEnd=${pomainSearch.timeEnd}&venderCode=${pomainSearch.venderCode}&venderName=${pomainSearch.venderName}&payType=${pomainSearch.payType}&status=${pomainSearch.status}&search=search&nowPage=${page.nowPage}">${p.poid}</a>
				</td>
				<td align="center">${p.createTime}</td>
				<td align="center">${p.accountName}</td>
				<td align="center">${p.venderName}</td>
				<td align="center">${p.tipFee}</td>
				<td align="center">${p.productTotal}</td>
				<td align="center">${p.poTotal}</td>
				<td align="center">${p.payType}</td>
				<td align="center">${p.prePayFee}</td>
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
	<div id="venderDiv" style="visibility: hidden;" class="product">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap="nowrap" ="nowrap="nowrap" " class="toolbar">&nbsp;</td>
				<td width="40px" nowrap="nowrap" class="toolbar"
					onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
					onClick="choiceAnonymous()"><img src="/SCM/images/confirm.gif">确定</td>
				<td width="20px" nowrap="nowrap" class="toolbar">|</td>
				<td width="40px" nowrap="nowrap" class="toolbar"
					onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
					onClick="hiddenDiv()"><img src="/SCM/images/cancel.gif">取消</td>
				<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="a1" name="venderDiv">
			<tr>
				<td class="title1">选择</td>
				<td class="title1">供应商编号</td>
				<td class="title1">供应商名称</td>
			</tr>
			<c:forEach items="${AllVenders}" var="av" varStatus="i">
				<tr onClick="selectItem(this)" onMouseOver="OMO1(event)"
					onDblClick="choice(${i.index})" align="center">
					<td>&nbsp;</td>
					<td>${av.venderCode}</td>
					<td>${av.name}</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
	</div>
	<input type="hidden" value="${page.nowPage}" name="page"/>
	<input type="hidden" value="${page.toTalPage}" name="pageT"/>
	<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="/SCM/common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
	<br />
	<br />
	<br />
	<br />
	<br />
	<script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="/SCM/script/common.js"></script>
	<script language="javascript" src="/SCM/script/CG.js"></script>
	<script type="text/javascript" src="/SCM/script/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="/SCM/script/jquery-ui-timepicker-addon.js"></script>
  <script type="text/javascript" src="/SCM/script/jquery-ui-timepicker-zh-CN.js"></script>
	<script language="javascript">
		$(function(){
			vArr=getArr("venderDiv");
			$("[value=重置]").click(function(){
				$("input:text").val("");
				$("option[value=]").attr("selected","selected");
			});
			$("[value=查询]").click(function(){
				if(!($("[name=venderCode]").val()==""&&$("[name=venderName]").val()!="")){
					$("form").submit();
				}
			});
//			$(".ui_timepicker").datetimepicker({
//            showSecond: true,
//            timeFormat: 'hh:mm:ss',
//            stepHour: 1,
//            stepMinute: 1,
//            stepSecond: 1
//       })
		});
		function dateTest(obj){
			var reg=/^\d{4}-\d{1,2}-\d{1,2}$/;
			if($(obj).val()!=""&&!reg.test($(obj).val())){
				alert("日期格式(yyyy-MM-dd)错误！");
				$(obj).val("");
				$(obj).focus();
			}
		}
		function color(obj){
			var b=false;
			for(var i=0;i<vArr.length;i++){
				if($(obj).val()==vArr[i][1]){b=true;$(obj).next().val(vArr[i][0]);break;}
			}
			if($(obj).val()==""||!b){$(obj).next().val("")}
		}
		function color1(){
			if($("[name=venderCode]").val()==""&&$("[name=venderName]").val()!="") $("[name=venderName]").focus();
		}
		function cPage(a){//a：0为首页，1为下一页，-1为上一页，2为末页
			 var cNum=$("[name=page]").val()-(-a);
			 if(a==2) cNum=$("[name=pageT]").val();
			 else if(a==0) cNum=1;
			 location="/SCM/PomainSearchServlet?&nowPage="+cNum+"&poidPart="+$("[name=poidPart]").val()+"&timeStart="+$("[name=timeStart]").val()+"&timeEnd="+$("[name=timeEnd]").val()+"&venderName="+$("[name=venderName]").val()+"&venderCode="+$("[name=venderCode]").val()+"&payType="+$("[name=payType]").val()+"&status="+$("[name=status]").val(); 
		}
		
	</script>
</body>
</html>
