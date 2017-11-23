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
    
    <title>产品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
	
	function add(){
		window.location.href="gztm/addProduct.jsp";
	}
	
	
	function addValidation(){
		var productCode=document.getElementsByName("productCode")[0].value;
		var name=document.getElementsByName("name1")[0].value;
		var unitName=document.getElementsByName("unitName")[0].value;
		var price =document.getElementsByName("price")[0].value;
		var productCodeReg=/[a-zA-Z0-9]{4,20}/;
		var nameReg=/\S{1,100}/;
		var priceReg=/[1-9]{1,}\.?[0-9]{0,2}/;
		if(productCodeReg.test(productCode)&&nameReg.test(name)&&unitName!=""&&priceReg.test(price)){
			return true;
		}else if(!productCodeReg.test(productCode)){
			alert("产品编号必须为4~20字符，字母和数字");
			return false;
		}else if(!nameReg.test(name)){
			alert("产品名称必须为1-100个字符");
			return false;
		}else if(unitName==""){
			alert("数量单位不能为空");
			return false;
		}else if(!priceReg.test(price)){
			alert("正确输入销售价格,小数点最多两位");
			return false;
		}
	}
	function allCheck(obj){
		var check=document.getElementsByName("check");
			for(var i=0;i<check.length;i++){
				check[i].checked=obj.checked;
			}
	}
	var arr=null+"-";
	function deletePro(){
		var con=confirm("确定删除吗");
		if(con){
			var check=document.getElementsByName("check");
			for(var i=0;i<check.length;i++){
				if(check[i].checked){
					var code=(check[i].parentNode.nextSibling.nextSibling.innerHTML)+"-";
					arr+=code;
				}
			}
			window.location="/SCM/DeleteProduct?arr="+arr;
		}else{
			
		}
		
	}
		
</script>

  </head>

<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－产品管理</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="add()"><img
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
				<td class="title1">全选<input type="checkbox" id="allCheckId" onclick="allCheck(this)"/></td>
				<td class="title1">产品编号</td>
				<td class="title1">产品名称</td>
				<td class="title1">数量单位</td>
				<td class="title1">分类名称</td>
				<td class="title1">添加日期</td>
				<td class="title1">销售价</td>
				<td class="title1">产品描述</td>
				<td class="title1">操作</td>
			</tr>
			
			<c:forEach items="${alProduct }" var="gd">
				<tr>
					<td align="center"><input type="checkbox" name="check"></td>
					<td align="center">${gd.productCode }</td>
					<td align="center">${gd.name }</td>
					<td align="center">${gd.unitName }</td>
					<td align="center">
						<c:forEach items="${alCategory }" var="gc">
							<c:if test="${gd.categoryID eq gc.categoryID }">${gc.name }</c:if>
						</c:forEach>
					</td>
					<td align="center">${gd.createDate }</td>
					<td align="center">${gd.price }</td>
					<td align="center">${gd.remark }</td>
					<td align="center"><a href="DisplayUpdateProduct?productCode=${gd.productCode }&categoryID=${gd.categoryID}&name=${gd.name }&unitName=${gd.unitName }&createDate=${gd.createDate }&price=${gd.price }&remark=${gd.remark }">修改</a></td>
				</tr>
			</c:forEach>
			<tr><td align="center"><input type="button" onclick="deletePro()" value="删除"/></td><td colspan="8"></td></tr>
		</table>
		<c:if test="${not empty alproductCodeInPoitem }">
			<span style="color:red">错误,以下用户已在采购单被使用:</span>
			<c:forEach items="${alproductCodeInPoitem }" var="aa" ><span style="color:red">${aa }、</span></c:forEach>
		</c:if>
		<c:if test="${not empty alproductCodeInSoitem }">
			<span style="color:red">错误,以下用户已在销售单被使用:</span>
			<c:forEach items="${alproductCodeInSoitem }" var="bb"><span style="color:red">${bb }、</span></c:forEach>
		</c:if>
		<c:if test="${not empty alGreaterThanZeroProductCode }">
			<span style="color:red">错误,一下产品库存大于零:</span>
			<c:forEach items="${alGreaterThanZeroProductCode }" var="cc"><span style="color:red">${cc }、</span></c:forEach>
		</c:if>
		<c:if test="${not empty deleteSuccess }"><span>${deleteSuccess }</span></c:if>
		<c:if test="${not empty noSelect }"><span style="color:red">错误:${noSelect }</span></c:if>
	</div>
	<div id="update" class="hidd">
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td class="title1">用户账号</td>
				<td class="title1">用户姓名</td>
			</tr>
			<tr>
				<td align="center">用户名</td>
				<td align="center"><input type="text" />
				</td>
			</tr>
			<tr>
				<td align="center">添加日期</td>
				<td align="center"><input name="jzrq" type="text" size="15"
					readonly="readonly"> <span class="requred_symbol">*</span>
					<a href="javascript:void(0)"
					onClick="gfPop.fPopCalendar(document.all.jzrq);return false;">
						<img name="popcal" src="images/selectDate.gif" width="15"
						height="12" border="0" alt="">
				</a></td>
			</tr>
			<tr>
				<td align="center">锁定状态</td>
				<td align="center"><input type="radio" name="y" />是 <input
					type="radio" name="y" />否"</td>
			</tr>
			<tr>
				<td align="center">用户权限</td>
				<td align="center"><input type="checkbox" />管理员<input
					type="checkbox" />采购<input type="checkbox" />仓管</td>
			</tr>
			<tr>
				<td height="18" colspan="2" align="center"><input type="reset" />
					<input type="button" value="保存" onClick="re()" />
				</td>
			</tr>
		</table>


	</div>

</body>
</html>
