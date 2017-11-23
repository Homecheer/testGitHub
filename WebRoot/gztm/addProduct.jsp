<%@page import="com.model.Category"%>
<%@page import="com.dao.CategoryDao"%>
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
    
    <title>增加产品</title>
    
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
	
	function addValidation(){
		var productCode=document.getElementsByName("productCode")[0].value;
		var name=document.getElementsByName("name1")[0].value;
		var unitName=document.getElementsByName("unitName")[0].value;
		var price =document.getElementsByName("price")[0].value;
		var productCodeReg=/[a-zA-Z0-9]{4,20}/;
		var nameReg=/\S{1,100}/;
		var priceReg=/^[0-9]{1,}\.?[0-9]{0,2}$/;
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
		
		
</script>

  </head>

<body>
<%CategoryDao cd= new CategoryDao();
		ArrayList<Category> alCategory=cd.allCategory();
		request.setAttribute("alCategory", alCategory); %>
	<div id="add">
		<form action="/SCM/AddProduct" method="get">
			<table width="100%" border="0" align="left" cellspacing="1" class="c">
				<tr>
					<td class="title1">产品编号</td>
					<td class="title1">产品名称</td>
					<td class="title1">产品分类</td>
					<td class="title1">销售价</td>
					<td class="title1">数量单位</td>
					<td class="title1">添加日期</td>
					<td class="title1">描述</td>
				</tr>
				<tr>
					<td align="center"><input type="text" name="productCode">
					</td>
					<td align="center"><input type="text" name="name1"></td>
					<td align="center"><select name="categoryName">
							<c:forEach items="${alCategory }" var="gc">
								<option>${gc.name }</option>
							</c:forEach>
					</select></td>
					<td align="center"><input type="text" name="price"></td>
					<td align="center"><input type="text" name="unitName">
					</td>
					<td align="center"><input type="text" disabled="disabled"
						value="当前日期"></td>
					<td align="center"><input type="text" name="remark"></td>
				</tr>
				<tr>
					<td align="center" colspan="7"><input type="reset" /> <input
						type="submit" onclick="return addValidation()" value="保存">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<c:if test="${not empty productCodeHasExist }"><span>${productCodeHasExist }</span></c:if>
	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

</body>
</html>
