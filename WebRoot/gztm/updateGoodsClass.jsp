<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改产品分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script type="text/javascript" src="script/productDiv.js"></script>
<script language="javascript" type="text/javascript">
	function query() {
		var params = new Object();
		var bm = new Array(8);
		bm[0] = "bdbh";
		bm[1] = "zt";
		bm[2] = "jzrq";
		bm[3] = "tdr";
		bm[4] = "strq";
		bm[5] = "tdrq";
		bm[6] = "lrrq";
		bm[7] = "lry";
		var mc = new Array(8);
		mc[0] = "表单编号";
		mc[1] = "表单状态";
		mc[2] = "截止日期";
		mc[3] = "填单人";
		mc[4] = "实提日期";
		mc[5] = "填单日期";
		mc[6] = "录入日期";
		mc[7] = "录入员";
		params.bm = bm;
		params.mc = mc;
		params.actionUrl = "";
		window.showModalDialog("common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
	
	
	
		
</script>

</head>

<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－修改产品分类</td>
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
		<form action="/SCM/UpdateCategory" method="get">
			<table width="100%" border="0" align="center" cellspacing="1"
				class="c">
				<tr>
					<td align="center">分类序列号</td>
					<td align="center"><input type="text" disabled="disabled" value="${categoryID }"/>
					</td>
				</tr>
				<tr>
					<td align="center">名称</td>
					<td align="center"><input type="text" name="name1" value="${name }"/></td>
					<td align="center" style="display:none"><input type="text" name="nameold" value="${name }"/></td>
				</tr>
				<tr>
					<td align="center">描述</td>
					<td align="center" ><input type="text" name="remark1" value="${remark }"/></td>
					<td align="center" style="display:none"><input type="text" name="remarkold" value="${remark }"/></td>
				</tr>
				<tr>
					<td height="18" colspan="2" align="center"><input type="reset" />
						<input type="submit" value="保存"/></td>
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
