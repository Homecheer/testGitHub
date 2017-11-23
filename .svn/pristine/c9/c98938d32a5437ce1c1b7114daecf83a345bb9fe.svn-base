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
<title>采购单新增</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/SCM/css/style.css" rel="stylesheet" type="text/css">
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

<body <c:if test="${empty getPomain}">onLoad="init()"</c:if>>

	<div class="formVisiblitly" id="formDiv"></div>
	<form
		<c:if test="${empty getPomain}">action="/SCM/PomainAddServlet"</c:if>
		<c:if test="${not empty getPomain}">action="/SCM/PomainModifyServlet?nowPage=${nowPage}"</c:if>
		name="mainForm" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="addItem()"><img
					src="/SCM/images/add.gif">增加明细</td>
				<td nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>

		<table id="headTable" width="100%" border="0" align="center"
			class="a1">
			<tr align="justify">
				<td>采购单编号</td>
				<td><input type="text" readonly required size="15" name="poid"
					<c:if test="${not empty getPomain}">value="${getPomain.poid}"</c:if> />
					<span class="requred_symbol">*</span>
				</td>
			
				<td>供应商选择</td>
				<td><input type="text" size="15" list="vender"
					name="venderName"
					<c:if test="${not empty getPomain}">value="${getPomain.venderName}"</c:if>
					oninput="color(this)" onblur="dataChoose(this)" /> <input
					type="hidden" name="venderCode"
					<c:if test="${not empty getPomain}">value="${getPomain.venderCode}"</c:if> />
					<!-- <datalist id="vender">
			   		<c:forEach items="${AllVenders}" var="av">
			   			<option value="${av.name}" label="${av.venderCode}"></option>
			   		</c:forEach>
			   	</datalist>--> <span class="LL"><image
							src="/SCM/images/selectDate.gif"
							onClick="choiceSpxx(${AllVenders.size()-1},'venderDiv')">
				</span> <span class="requred_symbol">*</span>
				</td>
				<td>创建用户</td>
				<!--value="${sUser.account}"-->
				<td>
				<input type="text" size="15" readonly name="accountName" 
				<c:if test="${empty getPomain}">value="${sUser.name}"</c:if>
				<c:if test="${not empty getPomain}">value="${getPomain.accountName}"</c:if> />
				<input type="hidden"  readonly name="account" 
				<c:if test="${empty getPomain}">value="${sUser.account}"</c:if>
				<c:if test="${not empty getPomain}">value="${getPomain.account}"</c:if> />
				</td>
				<td>备注</td>
				<td><input name="textfield" type="text" size="15"
					<c:if test="${not empty getPomain}">value="${getPomain.remark}"</c:if> />
				</td>
			</tr>
			<tr align="justify">
				<td>附加费用</td>
				<td><input type="text"
					<c:if test="${not empty getPomain}">value="${getPomain.tipFee}"</c:if>
					<c:if test="${empty getPomain}">value="0"</c:if> size="15"
					name="tipFee" required oninput="prePayFeeInP(this)"
					onblur="prePayFeeBlr(this)" /> <span class="requred_symbol">*</span>
				</td>
				<td>采购产品总价</td>
				<td><input type="text" size="15" readonly required
					name="productTotal"
					<c:if test="${not empty getPomain}">value="${getPomain.productTotal}"</c:if>
					<c:if test="${empty getPomain}">value="0"</c:if> /><span
					class="requred_symbol">*</span>
				</td>
				<td>付款方式</td>
				<td><select name="payType">
						<option value="货到付款"
							<c:if test="${not empty getPomain && getPomain.payType eq '货到付款'}">selected</c:if>>货到付款</option>
						<option value="款到发货"
							<c:if test="${not empty getPomain && getPomain.payType eq '款到发货'}">selected</c:if>>款到发货</option>
						<option value="预付款到发货"
							<c:if test="${not empty getPomain && getPomain.payType eq '预付款到发货'}">selected</c:if>>预付款到发货</option>
				</select><span class="requred_symbol">*</span></td>
				<td>最低预付款金额</td>
				<td><input type="text"
					<c:if test="${not empty getPomain}">value="${getPomain.prePayFee}"</c:if>
					<c:if test="${not empty getPomain && (getPomain.payType eq '货到付款' || getPomain.payType eq '款到发货')}">readonly</c:if>
					<c:if test="${empty getPomain}">value="0" readonly</c:if> size="15"
					name="prePayFee" required oninput="prePayFeeInP(this)"
					onblur="prePayFeeBlr(this)" /> <span class="requred_symbol">*</span>
				</td>
			</tr>
			<c:if test="${not empty getPomain}">
			<tr align="justify">
					<td>创建时间</td>
				<td><input size="15" name="createTime" readonly
					required type="text" value="${getPomain.createTime}" /><span
					class="requred_symbol">*</span>
				</td>
			</tr></c:if>
			<c:if test="${empty getPomain}"><input name="createTime" type="hidden" />
			</c:if>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			id="detailTable">
			<tr>
				<td class="toolbar">序号</td>
				<td class="toolbar">产品编码</td>
				<td class="toolbar">产品名称</td>
				<td class="toolbar">数量单位</td>
				<td class="toolbar">产品数量</td>
				<td class="toolbar">采购单价</td>
				<td class="toolbar">操作</td>
			</tr>
			<c:forEach items="${getPoitem}" var="p" varStatus="i">
				<tr align="center">
					<td>${i.index+1}</td>
					<td><input value="${p.productCode}" type="text" required
						name="productCode" size="10" oninput="color(this)"
						onblur="dataChoose(this)"><span class="LL"><image src="/SCM/images/selectDate.gif" onClick="choiceSpxx(${i.index},'productDiv')"></span><span class="requred_symbol">*</span>
						</td>
					<td><input value="${p.productName}" type="text" required
						name="productName" size="15" readonly><span
						class="requred_symbol">*</span>
					</td>
					<td><input value="${p.unitName}" type="text" required
						name="unitName" size="10" readonly><span
						class="requred_symbol">*</span>
					</td>
					<td><input value="${p.num}" type="text" required name="num"
						size="10" oninput="prePayFeeInP(this)" onblur="prePayFeeBlr(this)"><span
						class="requred_symbol">*</span>
					</td>
					<td><input value="${p.unitPrice}" type="text" required
						name="unitPrice" size="10" oninput="prePayFeeInP(this)"
						onblur="prePayFeeBlr(this)"><span class="requred_symbol">*</span>
					</td>
					<td><image src="/SCM/images/delete.gif" class="LL"
							onclick="delItem(${i.index+1})" />
					</td>
				</tr>
			</c:forEach>
		</table>
		<!--<datalist id="productCode"><c:forEach items="${AllProducts}" var="ap">
				<option value="${ap.productCode}" label="${ap.name},${ap.unitName}">
			</c:forEach></datalist>-->
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<input type="button" id="bc"
				<c:if test="${not empty getPomain}">value="修改"</c:if>
				<c:if test="${empty getPomain}">value="保存"</c:if> onclick="save()" />
			<c:if test="${not empty getPomain}">&nbsp;<input type="button"
					id="bc"
					onclick="window.location='/SCM/PomainServlet?nowPage=${nowPage}'"
					value="取消" />
			</c:if>
		</div>

		<div id="productDiv" style="visibility: hidden;" class="product">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="30px" nowrap="nowrap" ="nowrap="nowrap"
						" class="toolbar">&nbsp;</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
						onClick="choiceAnonymous()"><img
						src="/SCM/images/confirm.gif">确定</td>
					<td width="20px" nowrap="nowrap" class="toolbar">|</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
						onClick="hiddenDiv()"><img src="/SCM/images/cancel.gif">取消</td>
					<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellspacing="1"
				class="a1" name="productDiv">
				<tr>
					<td class="title1">选择</td>
					<td class="title1">产品编号</td>
					<td class="title1">产品名称</td>
					<td class="title1">数量单位</td>
				</tr>
				<c:forEach items="${AllProducts}" var="ap" varStatus="i">
					<tr onClick="selectItem(this)" onMouseOver="OMO1(event)"
						onDblClick="choice(${i.index})" align="center">
						<td>&nbsp;</td>
						<td>${ap.productCode}</td>
						<td>${ap.name}</td>
						<td>${ap.unitName}</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="title2"></td>
				</tr>
			</table>
		</div>

		<div id="venderDiv" style="visibility: hidden;" class="product">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="30px" nowrap="nowrap" ="nowrap="nowrap"
						" class="toolbar">&nbsp;</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
						onClick="choiceAnonymous()"><img
						src="/SCM/images/confirm.gif">确定</td>
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

	</form>

	<script language="javascript" src="/SCM/script/jquery-1.8.1.min.js"></script>
	<script language="javascript" src="/SCM/script/common.js"></script>
	<script language="javascript" src="/SCM/script/CG.js"></script>
	<script language="javascript">
			$(function(){
				pArr=getArr("productDiv");
				vArr=getArr("venderDiv");
				$("[name=payType]").change(function(){
					if($("[name=payType] option:selected").text()=="预付款到发货"){$("[name=prePayFee").attr("readonly",false);}
					else{$("[name=prePayFee").attr("readonly",true);$("[name=prePayFee").val("0")}
				});
			});
			function getTimeStr(i){
				var d=new Date();
				var year=d.getFullYear();
				var month=d.getMonth()+1;
				month=month>9?month:"0"+month;
				var date=d.getDate();
				date=date>9?date:"0"+date;
				var hours=d.getHours();
				hours=hours>9?hours:"0"+hours;
				var minutes=d.getMinutes();
				minutes=minutes>9?minutes:"0"+minutes;
				var seconds=d.getSeconds();
				seconds=seconds>9?seconds:"0"+seconds;
				var poid=year+""+month+""+date+""+hours+""+minutes+""+seconds;
				var createTime=year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds;
				if(i==1) return poid;
				else if(i==2) return createTime;
			}
			function prePayFeeInP(obj){
				var reg=null;
				if($(obj).attr("name")=="num") reg=/^\d*$/;
				else reg=/^\d*\.?\d*$/;
			  if(!reg.test($(obj).val())){
			  $(obj).val("0");
				//$(obj).val($(obj).val().substring(0,$(obj).val().length-1));
				}
				if(parseFloat($("[name=prePayFee]").val())>parseFloat($("[name=productTotal]").val())){$("[name=prePayFee]").val($("[name=productTotal]").val())}
			}
			function prePayFeeBlr(obj){$(obj).val(/^\.{0,1}$/.test($(obj).val())?0:parseFloat($(obj).val()));if(!/^\d/.test($(obj).val())){$(obj).val("0");}
				if($(obj).attr("name")=="num"||$(obj).attr("name")=="unitPrice"){
					setProductTotal();
				}
			}
			function setProductTotal(){
				var table=document.getElementById("detailTable");
					var total=0;
					for(var i=0;i<table.rows.length-1;i++){
						total+=parseFloat($("[name=num]").eq(i).val())*parseFloat($("[name=unitPrice]").eq(i).val());
					}
					$("[name=productTotal]").val(total);
			}
			function color(obj){
				$(obj).css("background","#FFFFFF");
				if($(obj).attr("name")=="productCode"){
					var b=false;
					for(var i=0;i<pArr.length;i++){
						if($(obj).val()==pArr[i][0]){b=true;$(obj).parent().parent().find("[name=productName]").val(pArr[i][1]);$(obj).parent().parent().find("[name=unitName]").val(pArr[i][2]);break;}
					}
					if(!b){$(obj).parent().parent().find("[name=productName]").val("");$(obj).parent().parent().find("[name=unitName]").val("");}
				}
				else if($(obj).attr("name")=="venderName"){
				var b=false;
					for(var i=0;i<vArr.length;i++){
						if($(obj).val()==vArr[i][1]){b=true;$(obj).next().val(vArr[i][0]);break;}
					}
					if($(obj).val()==""||!b){$(obj).next().val("")}
				}
			}
			function dataChoose(obj){
				var arr=null;
				var n=0;
				if($(obj).attr("name")=="productCode") {arr=pArr;n=0;}
				else if($(obj).attr("name")=="venderName") {arr=vArr;n=1;}
				var b=false;
				for(var i=0;i<arr.length;i++){
					if($(obj).val()==arr[i][n]){b=true;$(obj).css("background","#FFFFFF");break;}
				}
				if($(obj).attr("name")=="productCode"){
					var table=document.getElementById("detailTable");
					var row=table.rows;
					for(var i=1;i<row.length;i++){
						if($(obj).val()!=""&&$(obj).val()!=undefined&&$(obj).parent().parent().find("td:eq(0)").text()!=$(row[i].cells[0]).text()&&$(obj).val()==$(row[i].cells[1]).find("input").val()){
							alert("已有该产品的详细订单！");
							$(obj).val(undefined);
						//	$(obj).css("background-color","#FFF7E5");
							$(obj).parent().parent().find("[name=productName]").val("");
							$(obj).parent().parent().find("[name=unitName]").val("");
							//$(row[i].cells[1]).find("input").focus();
							return;}
					}
				}
				
				
				if(!b){$(obj).css("background-color","#FFF7E5");}
			}
		function save(){
			var flag1=false;
			var flag2=false;
			if(document.getElementById("detailTable").rows.length==1){alert("至少要有一条产品明细订单！");return;}
			if($("[name=venderCode]").val()==""){flag1=true;$("[name=venderName]").val("");$("[name=venderName]").css("background","#FFFFFF");}
			for(var i=0;i<document.getElementById("detailTable").rows.length-1;i++){
				if($("[name=productName]").eq(i).val()=="") {flag2=true;$("[name=productCode]").eq(i).val(undefined);}	
			}
			if(flag1) $("[name=venderName]").focus();
			else if(flag2) $("[name=productCode]").focus();
			else{$("[name=createTime]").val(getTimeStr(2));$("[name=mainForm]").submit();}
		}
		</script>
</body>
</html>
