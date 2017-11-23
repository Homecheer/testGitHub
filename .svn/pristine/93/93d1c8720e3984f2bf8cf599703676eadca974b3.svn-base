<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/style.css" rel="stylesheet" type="text/css">
    <base href="<%=basePath%>">
   <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
   <script type="text/javascript">
   		function add(){
   			document.getElementById("t1").style.display="none";
   			document.getElementById("t2").style.display="block";
   		}
   	function err1(){
   		alert("操作失败，已存在该编号");
   	}function err2(){
   		alert("操作失败，输入格式有误");
   	}function sucss(){
   		alert("操作成功");
   	}function change(obj){
   		document.getElementById("t1").style.display="none";
   		document.getElementById("t2").style.display="block";
   		document.getElementById("i1").value= obj.parentNode.parentNode.cells[0].innerHTML;
   		document.getElementById("i2").value=obj.parentNode.parentNode.cells[1].innerHTML;
   		document.getElementById("i3").value=obj.parentNode.parentNode.cells[2].innerHTML;
   		document.getElementById("i4").value=obj.parentNode.parentNode.cells[3].innerHTML;
   		document.getElementById("i5").value=obj.parentNode.parentNode.cells[4].innerHTML;
   		document.getElementById("i6").value=obj.parentNode.parentNode.cells[5].innerHTML;
   		document.getElementById("i7").value=obj.parentNode.parentNode.cells[6].innerHTML;
   		document.getElementById("i8").value=obj.parentNode.parentNode.cells[7].innerHTML;
   		document.getElementById("i9").value=obj.parentNode.parentNode.cells[8].innerHTML;
   		document.getElementById("i10").value="change";
   		$("#i1").attr("readOnly",true);
   	}function del(obj){
   		var CustomerCode=obj.parentNode.parentNode.cells[0].innerHTML;
   		location="AddCustomServlet?CustomerCode="+CustomerCode;
   	}
   	
   </script>
    <title>客户管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body <c:choose><c:when test="${not empty dou}">onload="err1()"</c:when><c:when test="${not empty formaterror}">onload="err2()"</c:when><c:when test="${not empty sucss}">onload="sucss()"</c:when></c:choose>> 
    
  <h3 align="center">客户管理</h3>
    <table width="100%" border="1" cellspacing="0" id="t1" class="a1">
    	<tr>
    		<th>CustomerCode</th>
    		<th>Name</th>
    		<th>Password</th>
    		<th>Contactor</th>
    		<th>Address</th>
    		<th>Postcode</th>
    		<th>Tel</th>
    		<th>Fax</th>
    		<th>CreateDate</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${al }" var="cus">
    		<tr>
    		<td>${cus.getCustomerCode() }</td>
    		<td>${cus.getName() }</td>
    		<td>${cus.getPassword() }</td>
    		<td>${cus.getContactor() }</td>
    		<td>${cus.getAddress() }</td>
    		<td>${cus.getPostcode() }</td>
    		<td>${cus.getTel() }</td>
    		<td>${cus.getFax() }</td>
    		<td>${cus.getCreateDate() }</td>
    		<td><input type="button" value="修改" onclick="change(this)"><input type="button" value="删除" onclick="del(this)"></td>
    		</tr>
    	</c:forEach>
    </table>
    
    <input type="button" value="新增" onclick="add()">
    
    <table id="t2" border="1" cellspacing="0" style="margin:auto;display:none;">
    <form action="AddCustomServlet" method="post">
    	<tr><td>CustomerCode</td><td><input id="i1" type="text" name="text1" placeholder="4-20位字母数字"></td></tr>
  		 <tr><td>Name</td><td><input id="i2" type="text" name="text2" placeholder="不超过100位"></td></tr>
  	 	 <tr><td>Password</td><td><input id="i3"  type="password" name="text3" placeholder="4-20位字母数字"></td></tr>
  	  <tr><td>Contactor</td><td><input id="i4"  type="text" name="text4"></td></tr>
  	  <tr><td>Address</td><td><input id="i5"  type="text" name="text5" placeholder="不超过10位"></td></tr>
  	  <tr><td>Postcode</td><td><input  id="i6" type="text" name="text6" placeholder="可以为空,不超过8位"></td></tr>
  	  <tr><td>Tel</td><td><input  id="i7" type="text" name="text7" placeholder="不超过20位"></td></tr>
  	  <tr><td>Fax</td><td><input id="i8"  type="text" name="text8" placeholder="可以为空,不超过20位"></td></tr>
   	 <tr><td>CreateDate</td><td><input id="i9"  type="text" name="text9" readonly="readonly" placeholder="自动生成"></td></tr>
   	 <tr style="display: none;"><td>123</td><td><input id="i10"  type="text" name="text10"></td></tr>
   	 <tr ><td colspan="2" align="center"><input type="submit" ></td></tr>
   	 </form>
    </table>
    
    
  </body>
</html>
