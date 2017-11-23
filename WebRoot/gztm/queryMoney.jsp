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
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
	<script type="text/javascript">
		function deleteTab(){
			var tb=document.getElementById("tb");
			var trs=tb.rows;
			var ll=trs.length-1;
			for(var i=0;i<ll;i++){
				tb.deleteRow(1);
			}
		}
		function jquerytest(){
			var startTime=document.getElementById("startTime").value;
			var endTime=document.getElementById("endTime").value;
			var ioType=document.getElementById("ioType").value;
			var payType=document.getElementById("payType").value;
			var id=document.getElementById("id").value;
			$.get(
				"QueryInOrOut",
				{"startTime":startTime,"endTime":endTime,"ioType":ioType,"payType":payType,"id":id},
				function(data){
					var arr=eval("("+data+")");
					var tab=document.getElementById("tb");
					deleteTab();
					for(var i=0;i<arr.length;i++){
							if(arr[i].soid!=null){
							var io="收入";
							var paytype=arr[i].payType;
							var paytime=arr[i].payTime;
							var soid=arr[i].soid;
							var sototal=arr[i].soTotal;
							var payuser=arr[i].payUser;
							var prepayuser=arr[i].prePayUser;
							var prepaytime=arr[i].prePayTime;
							
							var row = tab.insertRow(-1);
							var cell = row.insertCell(-1);
							cell.innerHTML = io;
							var cell = row.insertCell(-1);
							if(paytime!=""&&paytime!=null){
							cell.innerHTML = paytime;							
							}else if(prepaytime!=""&&prepaytime!=null){
							cell.innerHTML = prepaytime;
							}
							var cell = row.insertCell(-1);
							cell.innerHTML = soid;
							var cell = row.insertCell(-1);
							cell.innerHTML = sototal;
							var cell = row.insertCell(-1);
							if(payuser!=""&&payuser!=null){
							cell.innerHTML = payuser;
							}else if(prepayuser!=""&&prepayuser!=null){
							cell.innerHTML = prepayuser;
							}
							var cell = row.insertCell(-1);
							cell.innerHTML = paytype;
						}else if(arr[i].poid!=null){
							var io="支出";
							var paytype=arr[i].payType;
							var paytime=arr[i].payTime;
							var poid=arr[i].poid;
							var pototal=arr[i].poTotal;
							var payuser=arr[i].payUser;
							var prepayuser=arr[i].prePayUser;
							var prepaytime=arr[i].prePayTime;
							
							var row = tab.insertRow(-1);
							var cell = row.insertCell(-1);
							cell.innerHTML = io;
							var cell = row.insertCell(-1);
							if(paytime!=""&&paytime!=null){
							cell.innerHTML = paytime;							
							}else if(prepaytime!=""&&prepaytime!=null){
							cell.innerHTML = prepaytime;
							}
							var cell = row.insertCell(-1);
							cell.innerHTML = poid;
							var cell = row.insertCell(-1);
							cell.innerHTML = pototal;
							var cell = row.insertCell(-1);
							if(payuser!=""&&payuser!=null){
							cell.innerHTML = payuser;
							}else if(prepayuser!=""&&prepayuser!=null){
							cell.innerHTML = prepayuser;
							}
							var cell = row.insertCell(-1);
							cell.innerHTML = paytype;
						}
					}
				}
			);
		}
	</script>
  </head>
  
  <body>
    <div id="update">
	<form>
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td align="center">开始日期</td>
    <td align="center"><input id="startTime" type="text" size="15"/>
        <span class="requred_symbol">*</span>
        <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.startTime);return false;">
        <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a></td>
	</tr>
  <tr>
    <td align="center">截至日期</td>
    <td align="center">
    	<input id="endTime" type="text" size="15"/>
        <span class="requred_symbol">*</span>
        <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.endTime);return false;">
        <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
    </td>
	</tr>
  <tr>
    <td align="center">收支类型</td>
    <td align="center">
    	<select id="ioType">
    		<option>收入</option>
    		<option>支出</option>
    	</select>
    </td>
	</tr>
	
  <tr>
    <td align="center">单据付款方式</td>
    <td align="center">
    	<select id="payType">
    		<option></option>
    		<option>货到付款</option>
    		<option>款到发货</option>
    		<option>预付款发货</option>
    	</select>
    </td>
	</tr>
	<tr>
    <td align="center">相关单据号</td>
    <td align="center">
    	<input type="text" id="id"/>
    </td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="reset"/> <input type="button" onclick="jquerytest()" value="查询"/></td>
    </tr>
</table>
</form>
<br>

<table width="100%"  border="0" align="center" cellspacing="1" class="c" id="tb">
  <tr>
  	<td align="center">收支类型</td>
  	<td align="center">日期</td>
  	<td align="center">相关单据号</td>
  	<td align="center">收支金额</td>
  	<td align="center">经手人</td>
  	<td align="center">单据付款方式</td>
  </tr>
  <%-- <c:forEach items="${soAlist }" var="sa">
  	<tr>
  		<td>收入</td>
  		<td>${sa.payTime }${sa.prePayTime }</td>
  		<td>${sa.soid }</td>
  		<td>${sa.soTotal }</td>
  		<td>${sa.payUser}${sa.prePayUser }</td>
  		<td>${sa.payType }</td>
  	</tr>
  </c:forEach> --%>
 <%--  <c:forEach items="${poAlist }" var="pa">
  	<tr>
  		<td>支出</td>
  		<td>${pa.payTime }${pa.prePayTime }</td>
  		<td>${pa.poid }</td>
  		<td>${pa.poTotal }</td>
  		<td>${pa.payUser}${pa.prePayUser }</td>
  		<td>${pa.payType }</td>
  	</tr>
  </c:forEach> --%>
</table>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>
