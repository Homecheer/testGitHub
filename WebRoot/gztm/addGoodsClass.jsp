<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分类管理</title>
    
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
	
	function update(){
		document.getElementById("m").style.display="none";
		document.getElementById("add").style.display="block";
		}
	function validation(){
		var name=document.getElementsByName("name1")[0].value;
		if(name==""){
			alert("名称不能为空");
			return false;
		}
		return true;
	}	
</script>

  </head>

<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－新增产品分类</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)"></td>
				<td width="20px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)"></td>
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
				<td class="title1">&nbsp;</td>
			</tr>
		</table>
	</div>
	<div id="add">
	<form action="/SCM/AddCategory"  method="get">
		<table width="100%" border="0" align="center" cellspacing="1" class="c">
			<tr>
				<td align="center">分类序列号</td>
				<td align="center"><input type="text" disabled="disabled" /></td>
			</tr>
			<tr>
				<td align="center">名称</td>
				<td align="center"><input type="text" name="name1"/></td>
			</tr>
			<tr>
				<td align="center">描述</td>
				<td align="center"><input type="text" name="remark1"/></td>
			</tr>
			<tr>
				<td height="18" colspan="2" align="center">
					<input type="reset" />
					<input type="submit" value="保存" onclick="return validation()"/>
				</td>
			</tr>
		</table>
	</form>

	</div>

	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

</body>
</html>
