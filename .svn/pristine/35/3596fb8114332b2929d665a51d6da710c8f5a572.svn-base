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

<title>更改产品</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script type="text/javascript" src="script/productDiv.js"></script>
<script language="javascript" type="text/javascript">
	function updateValidation(){
		var name=document.getElementsByName("name1")[0].value;
		var unitName=document.getElementsByName("unitName")[0].value;
		var price =document.getElementsByName("price")[0].value;
		var nameReg=/\S{1,100}/;
		var priceReg=/^[0-9]{1,}\.?[0-9]{0,2}$/;
		if(nameReg.test(name)&&unitName!=""&&priceReg.test(price)){
			return true;
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
</script>

</head>

<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－产品管理－－修改</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar"></td>
				<td width="20px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar"></td>
				<td nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
	<form action="/SCM/UpdateProduct" method="get">	
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				
				<td class="title1">产品编号</td>
				<td class="title1">产品名称</td>
				<td class="title1">数量单位</td>
				<td class="title1">产品分类</td>
				<td class="title1">添加日期</td>
				<td class="title1">销售价</td>
				<td class="title1">产品描述</td>
				
			</tr>

			
				<tr>
					<td align="center"><input type="text" name="productCode" disabled="disabled" value="${productCode }"></td>
					<td style="display:none"><input type="text" name="productCode1"  value="${productCode }"></td><!--disabled的表单属性没办法传到servlet,需要个隐藏单元辅助-->
					<td align="center"><input type="text" name="name1" value="${name }"></td>
					<td align="center"><input type="text" name="unitName" value="${unitName }"></td>
					<td align="center">
						 <select name="categoryName">
							<c:forEach items="${alCategory }" var="gc">
								<option <c:if test="${categoryID eq gc.categoryID }">selected="selected"</c:if>>${gc.name }</option>
							</c:forEach>
						</select>
					</td>
					<td align="center"><input type="text"  disabled="disabled" value="当前时间"></td>
					<td align="center"><input type="text" name="price" value="${price }"></td>
					<td align="center"><input type="text" name="remark" value="${remark }"></td>
					
				</tr>
			
				<tr><td align="center" colspan="7"><input type="reset">&nbsp;<input type="submit" value="保存" onclick="return updateValidation()"></td></tr>
		</table>
	</form>
	</div>
</body>
</html>
