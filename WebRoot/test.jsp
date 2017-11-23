<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>
		<table width="100%" bgcolor="blue">
			<tr>
				<td>add query</td>
				<td width="80%"></td>
				<td  align="right">未审核|已审核|好阿里</td>
			</tr>
		</table>
	</body>
</html>