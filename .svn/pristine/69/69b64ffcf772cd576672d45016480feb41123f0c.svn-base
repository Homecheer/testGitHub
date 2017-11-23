<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>采购单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
 <script language="javascript" src="script/jquery-1.8.1.min.js"></script>
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>

<style type="text/css">
	div.product{
		position: absolute;
		top:2px;
		left: 2px;
		width:100%;
		height: 98%;
		background-color: #fffffe;
	}

</style>
<script language="javascript">
	function test(){
		document.getElementById("con").style.display="block";
		}
	function choosepay(){
		var i=document.getElementById("s1").selectedIndex;
		if(i==1){
			$("#i1").attr("readOnly",false);
		}else{
			$("#i1").attr("readOnly",true);
		}
	}function calpropri(obj){
		var rows=document.getElementById("detailTable").rows;
		var num=0;
		for(var i=rows.length-1;i>=1;i--){
			num+=parseInt($(rows[i].cells[6]).children("input:first").val());
		}
		obj.value=num;
	}function err(){
		alert("格式错误，请检查！");
	}function dup(){
		alert("同一订单下不能拥有相同的商品或者购买量超过库存");
	}
</script>
</head>
<div >
</div>
<body onLoad="init()<c:if test="${not empty error1 }">;err()</c:if><c:if test="${not empty doubleproduct }">;dup()</c:if>">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单添加</td>
  </tr>
</table>
<div class="formVisiblitly" id="formDiv"></div>
<form action="AddMainItemServlet" name="mainFrm" method="post">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.mx.click()"><img src="images/add.gif">增加明细</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.bc.click()"><img src="images/save.gif">保存</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.ts.click()"><img src="images/send.gif">提审</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.dy.click()"><img src="images/search.gif">打印</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.cz.click()"><img src="images/reset.gif">重置</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.gb.click()"><img src="images/cancel.gif">关闭</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>

<table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>销售单编号</td>
    <td><input type="text" name="i1" size="15" value="${ordernumber }" readonly="false"/>
      <span class="requred_symbol">*</span></td>
    <td>创建时间</td>
    <td><input name="i4" type="text" size="15" value="${time }" readonly="false"/>
      <span class="requred_symbol">*</span></td>
    <td>客户名称</td>
    <td><select name="i2">
    	<c:forEach items="${al }" var="aa">
    		<option>${aa }</option>
    	</c:forEach>       	
        </select>
      </td>
    <td>创建用户</td>
    <td>
    	<input value="${sUser.name}" readonly size="15"/>      	
      <input type="hidden" value="${sUser.account}" name="i3"/>
    </td>
  </tr>
  <tr align="justify">
    <td>附加费用</td>
    <td><input name="i5" type="text" size="15" placeholder="不能为空，不超过10位"/>
        <span class="requred_symbol">*</span></td>
    <td>产品总价</td>
    <td><input name="i6" type="text" size="15" placeholder="根据明细表自动生成" onclick="calpropri(this)"/></td>
    <td>付款方式</td>
    <td>
    	<select onclick="choosepay()" id="s1" name="i7" value="0">
        	<option>货到付款</option>
            <option>预付款到发货</option>
            <option>款到发货</option>
        </select>
    </td>
    <td>最低预付金额</td>
    <td><input name="i8" name="text" id="i1" type="text" size="15" readonly="false"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">&nbsp;</td>
    <td class="toolbar"> 商品编码 </td>
    <td class="toolbar"> 商品名称 </td>
    <td class="toolbar"> 产品数量 </td>
    <td class="toolbar">数量单位</td>
    <td class="toolbar">销售单价</td>
    <td class="toolbar">销售明细总价</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>
<div align="center">
    <input type="button" id="mx" value="增加明细" onClick="addItem()"/>
    <input type="submit" id="bc" value="保存"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
    <input name="reset"  id="cz" value="重置" type="reset"/>
    <input type="button" id="gb" value="关闭" onClick="window.close()"/>
</div>

<!-- div -->
 
<div id="productDiv" style="visibility: hidden;" class="product">
	
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap"="nowrap="nowrap"" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">商品编码</td>
	    <td class="title1">商品名称</td>
	    <td class="title1">商品体积</td>
	    <td class="title1">商品重量</td>
	  </tr>
	  <c:forEach items="${alproduct }" var="alp">
		  <tr onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(1)" align="center">
		    <td>&nbsp;</td>
		    <td>${alp.getId() }</td>
		    <td>${alp.getName() }</td>
		    <td>${alp.getWeight() }</td>
		    <td></td>
		  </tr>
	  </c:forEach>
	  
	 
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>


</form>
 
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
