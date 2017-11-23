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
    
    <title>My JSP 'th.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<link type="text/css" href="css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
     <link type="text/css" href="css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>
   <!-- <script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        });
    })
    </script>-->
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
	$(function(){
		$("[value=go]").click(function(){
			var reg=/^[0-9]+$/;
			if(!(reg.test($("#ye").val()))||parseInt($("#ye").val())>parseInt(${page.totalpage })||parseInt($("#ye").val())<1){
				alert("请输入正确的数字");
			}else{
				location="manage?num="+$("#ye").val()+"&nowPage="+$("#sp").text();						
			}
		});
		
	});
	function add(){
		document.getElementById("m").style.display="none";
		document.getElementById("add").style.display="block";
		}
	function re(){
		document.getElementById("m").style.display="block";
		document.getElementById("add").style.display="none";
		}
	function deleteUser(obj){
		var flag=confirm("是否要删除");
		if(flag){
			location="DeleteScmUser?account="+obj.parentNode.parentNode.firstChild.nextSibling.innerHTML;
		}
	}	
	
	function time() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month<10) month="0"+month;
		var day = date.getDate();
		if(day<10) day="0"+day;
		var house = date.getHours();
		if(house<10) house="0"+house;
		var minutes = date.getMinutes();
		if(minutes<10) minutes="0"+minutes;
		var second = date.getSeconds();
		if(second<10) second="0"+second;
		//var milsecond = date.getMilliseconds();
		document.getElementsByName("createdate")[0].value = year + "-" + month
				+ "-" + day + " " + house + ":" + minutes + ":" + second;return true;
	}
</script>

  </head>
  
 <body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－用户管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" width="30px" onClick="add()"><img src="images/new.gif">新增</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1">用户账号</td>
    <td class="title1">用户姓名</td>
	<td class="title1">添加日期</td>
    <td class="title1">锁定状态</td>
    <td class="title1">用户权限列表</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page.aUsers}" var="sa">
  	<tr>
  		<td align="center" id="td">${sa.account}</td>
  		<td align="center">${sa.name}</td>
  		<td align="center">${sa.createDate}</td>
  		<td align="center">
  			<c:if test="${sa.status eq 'n'}">激活的</c:if>
  			<c:if test="${sa.status eq 'y'}"><span style="color:#FF0000">已锁定</span></c:if>
  		</td>
  		<td align="center">${sa.modelName}</td>
  		<td align="center"><a href="updateScmUser?account=${sa.account}&modelName=${sa.modelName}">修改</a> <a onClick="deleteUser(this)">删除</a></td>
  	</tr>
  </c:forEach>

</table>
这是第${page.nowPage }页,共${page.totalpage }页
		<span id="sp" style="display:none">${page.nowPage }</span>
    	<a href="manage?num=1">首页</a>
    	<c:choose>
    	<c:when test="${page.nowPage==page.totalpage}">
			<c:if test="${page.totalpage ne '1' }">
    		<a href="manage?num=${page.nowPage-1 }">上一页</a>
			</c:if>
    	</c:when>
    	<c:when test="${page.nowPage==1 }">
			<c:if test="${page.totalpage ne '1' }">
    		<a href="manage?num=${page.nowPage+1 }">下一页</a>
			</c:if>
    	</c:when>
    	<c:otherwise>
    		<a href="manage?num=${page.nowPage-1 }">上一页</a>
    		<a href="manage?num=${page.nowPage+1 }">下一页</a>
    	</c:otherwise>
    	</c:choose>
    	<a href="manage?num=${page.totalpage }">末页</a>
    	&nbsp&nbsp<input type="text" style="width:30" id="ye"/><input type="button" value="go">
 <c:if test="${not empty deletesuccess }"><span style="color: red">${deletesuccess}</span></c:if>
 <c:if test="${not empty deleteError1 }"><span style="color: red">${deleteError1}</span></c:if>
 <c:if test="${not empty deleteError }"><span style="color: red">${deleteError}</span></c:if>
 <c:if test="${not empty adderror }"><span style="color: red">${adderror}</span></c:if>
 <c:if test="${not empty addError1 }"><span style="color: red">${addError1}</span></c:if>
 <c:if test="${not empty addsuccess }"><span style="color: red">${addsuccess}</span></c:if>
 <c:if test="${not empty updateSuccess }"><span style="color: red">${updateSuccess}</span></c:if>
 <c:if test="${not empty goToYeError }"><span style="color: red">${goToYeError}</span></c:if>
</div>

<div id="add" class="hidd">
    <form action="adduser">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td align="center">用户账号</td>
    <td align="center"><input type="text" name="account"/></td>
	</tr>
  <tr>
    <td align="center">用户名</td>
    <td align="center"><input type="text" name="name"/></td>
	</tr>
  <tr>
    <td align="center">密码</td>
    <td align="center"><input type="text" name="password"/></td>
	</tr>
	
  <!--<tr>
    <td align="center">添加日期</td>
    <td align="center">
    	<input type="text"  class="ui_timepicker" readonly="readonly" name="createdate">
    </td>
	</tr>-->
	<input type="hidden"  class="ui_timepicker" readonly="readonly" name="createdate">
  <tr>
    <td align="center">锁定状态</td>
    <td align="center"><input type="radio" name="y" value="y"/>是 <input type="radio" checked="checked" name="y" value="n"/>否</td>
	</tr>
  <tr>
    <td align="center">用户权限</td>
    <td align="center"><input type="checkbox" name="gl" value="1"/>人事<input type="checkbox" name="cg" value="5"/>采购<input type="checkbox" name="cz" value="4"/>仓储<input type="checkbox" name="xs" value="2"/>销售<input type="checkbox" name="cw" value="3"/>财务</td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="reset"/> <input type="submit" value="增加" onclick="return time()"/></td>
    </tr>
</table>
</form>
</div>


<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
