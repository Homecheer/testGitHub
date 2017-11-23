<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function index(){
  			
  			if($('#memory').text()!=null){
  				var memory= $('#memory').text();
  				location="SellFormServlet?now=1&memory="+memory;
  			}
  		}
  		function nextpage(){
  			if($('#memory').text()!=null){
  				var memory= $('#memory').text();
  				var now=parseInt($('#nowpage').text())+1;
  				
  				location="SellFormServlet?now="+now+"&memory="+memory;
  			}
  		}
  		function lastpage(){
  			if($('#memory').text()!=null){
  				var memory= $('#memory').text();
  				var now=parseInt($('#nowpage').text())-1;
  				
  				location="SellFormServlet?now="+now+"&memory="+memory;
  			}
  		}function finalpage(){
  			if($('#memory').text()!=null){
  				var memory= $('#memory').text();
  				var now=$('#totalpage').text();
  				
  				location="SellFormServlet?now="+now+"&memory="+memory;
  			}
  		}
  	</script>
    <base href="<%=basePath%>">
    <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
  	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
    <title>My JSP 'showform.jsp' starting page</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－报表查询</td>
		</tr>
	</table>
   	<div class="formVisiblitly" id="formDiv"></div>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
 		<tr>
			<td nowrap class="toolbar">&nbsp;</td>
 	 	</tr>
	</table>
   <table  width="100%"  border="0" align="center" class="a1">
   <form action="SellFormServlet">
  		<tr align="justify">
    		<td>创建时间</td>
    		
   			 <!--  <td><select name="i1">	
    			<c:forEach items="${al }" var="aa">
    				<option>${aa.getTime() }</option>
    			</c:forEach>       	
      		 </select>
     		 </td>-->
     		 
     		  <td>
    		 	<input name="i1" type="text" size="15"  readonly="readonly"/>
    		 	 <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.i1);return false;">
        <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
    		 </td>  
     		 
     		 <td><input type="submit" value="查询"> <span id="memory" style="display:none;">${memory }</span></td>
  			</tr>
  			
  	</form>		
</table>
<c:forEach items="${page.data }" var="sm">
<table  width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td >销售单编号</td>
    <td><input name="num" type="text" size="15" value="${sm.getSOID() }" id="iorder" readonly="readonly"/></td>
    <td>创建时间</td>
    <td><input name="t4" type="text" size="15" value="${sm.getCreateTime() }" readonly="readonly"/></td>
    <td >客户名称</td>
    <td>
    	<select name="t2">
    		<c:forEach items="${alcusname }" var="cusname">
    			<option  <c:if test="${cusname eq sm.getCustomerCode()}">selected</c:if>>${cusname }
    			</option>
    		</c:forEach>
    	</select>
    
    	
     </td>
    <td>创建用户</td>
    <td>
   	 <select name="t3">
    		<c:forEach items="${alaccount }" var="account">
    			<option  <c:if test="${account eq sm.getAccount()}">selected</c:if>>${account }
    			</option>
    		</c:forEach>
    	</select>
    </td>
  </tr>
  <tr align="justify">
    <td>附加费用</td>
    <td><input name="t5" type="text" size="15" value="${sm.getTipFee() }"/></td>
    <td>产品总价</td>
    <td><input  name="t6" type="text" size="15" value="${sm.getProductTotal() }" style=""disabled="disabled"/></td>
    <td>付款方式</td>
    <td>
    	<select id="s1" name="t8">
    			<option  <c:if test="${sm.getPayType() eq '预付款到发货'}">selected</c:if>>预付款到发货</option>
    			<option  <c:if test="${sm.getPayType() eq '货到付款'}">selected</c:if>>货到付款</option>
    			<option  <c:if test="${sm.getPayType() eq '款到发货'}">selected</c:if>>款到发货</option>
    	</select>
    	
    </td>
    <td>最低预付金额</td>
    	<td><input  type="text" name="t9" id="prepay" size="15" value="${sm.getPrePayFee() }" readonly="readonly" onclick="changeprepay()"/></td>
   </tr>
 
  <tr>
  	<td>出库登记时间</td>
  	 <td><input type="text" size="15" name="t12" value="${sm.getStockTime() }"/></td>
  	<td>出库登记用户</td>
  	<td><input type="text" size="15" name="t13" value="${sm.getStockUser() }"/></td>
  	<td>付款登记时间</td>
  	<td><input type="text" size="15" name="t14" value="${sm.getPayTime() }"/></td>
  	<td>付款登记用户</td>
  	<td><input type="text" size="15" name="t15" value="${sm.getPayUser() }"/></td>
  </tr>
 
  <tr>
  	<td>预付登记时间</td>
  	<td><input type="text" size="15" name="t16" value="${sm.getPrePayTime() }"/></td>
  	<td>预付登记用户</td>
  	<td><input type="text" size="15" name="t17" value="${sm.getPrePayUser() }"/></td>
  	<td>了结时间</td>
  	<td><input type="text" size="15" name="t18" value="${sm.getEndTime() }"/></td>
 	 <td>了结用户</td>
 	 <td><input type="text" size="15" name="t19" value="${sm.getEndUser() }"/></td>
  </tr> 
   </table>
    </c:forEach>
    
     当前第<a id="nowpage">${page.nowPage }</a>页  共<a id="totalpage">${page.totalPage }</a>页
   	 <a onclick="index()">首页</a>
   	 <c:choose>
   	 	<c:when test="${page.nowPage==1 }">
   	 		<a onclick="nextpage()">下一页</a>
   	 	</c:when>
   	 	<c:when test="${page.nowPage==page.totalPage}">
   	 		<a onclick="lastpage()">上一页</a>
   	 	</c:when>
   	 	<c:otherwise>
   	 		<a onclick="lastpage()">上一页</a>
    		<a onclick="nextpage()">下一页</a>
   	 	</c:otherwise>
   	 </c:choose>   
    <a onclick="finalpage()">末页</a>
    
   <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="/SCM/common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>
