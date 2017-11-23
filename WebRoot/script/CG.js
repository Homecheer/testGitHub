
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;
var str;
var pArr;
var vArr;
function init() {
	$("[name=poid]").val(getTimeStr(1));
}
function getArr(divName){
	var arr=new Array();
	var table=document.getElementsByName(divName)[0];
	var row=table.rows;
	var lr=row.length;
	var lc=row[0].cells.length;
	for(var i=0;i<lr-2;i++){
		arr[i]=new Array();
		for(var j=0;j<lc-1;j++){
			arr[i][j]=row[i+1].cells[j+1].innerHTML;
		}
	}
	//alert(arr.length);
	return arr;
}

//逻辑控制
function choiceAnonymous(){
	var len = spxxTable.rows.length;
	var returnValue;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			if(str=="productDiv"){
				setValueP();}
			else if(str=="venderDiv"){
				setValueV();}
			hiddenDiv();
			return;
		}
	}
	alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
	function setValueP() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var productCode = document.getElementsByName("productCode");
		var productName = document.getElementsByName("productName");
		var unitName = document.getElementsByName("unitName");
	//	var spzl = document.getElementsByName("spzl");
		productCode[rowIndex].value = returnValue[0];
		productName[rowIndex].value = returnValue[1];
		unitName[rowIndex].value = returnValue[2];
		//spzl[rowIndex].value = returnValue[3];
		$(productCode[rowIndex]).css("background","#FFFFFF");
		
		row=detailTable.rows;
		for(var i=1;i<row.length;i++){
			if($(productCode[rowIndex]).val()!=""&&$(productCode[rowIndex]).val()!=undefined&&$(productCode[rowIndex]).parent().parent().find("td:eq(0)").text()!=$(row[i].cells[0]).text()&&$(productCode[rowIndex]).val()==$(row[i].cells[1]).find("input").val()){
				alert("已有该产品的详细订单！");
				$(productCode[rowIndex]).val(undefined);
				$(productCode[rowIndex]).parent().parent().find("[name=productName]").val("");
				$(productCode[rowIndex]).parent().parent().find("[name=unitName]").val("");
				//$(row[i].cells[1]).find("input").focus();
			}
		}
		
	}
	function setValueV() {
		var venderCode = document.getElementsByName("venderCode");		
		var venderName = document.getElementsByName("venderName");
		venderCode[0].value = returnValue[0];
		venderName[0].value = returnValue[1];
		$(venderName[0]).css("background","#FFFFFF");
	}
		
}
function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
}
function choice(index) {
	var row = spxxTable.rows[index];
	var result = new Array(rowlength);
	var i;
	for (i = 1; i < rowlength; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}
function choiceSpxx(rowIndex_,str1) {
	str=str1;
	spxxTable = document.getElementsByName(str)[0];
	rowlength = document.getElementsByName(str)[0].rows[0].cells.length;
	showDiv(str);
	rowIndex = rowIndex_;
	
	var table=document.getElementsByName(str)[0];
	//alert($(table).children("tr").html());
	$(table).find("tr:gt(0)").remove();
	var arr=null;
	var codePart="";
	var vn=1;
	if(str=="productDiv") {arr=pArr;codePart=$("[name=productCode]").eq(rowIndex_).val()==undefined?"":$("[name=productCode]").eq(rowIndex_).val();}
	else if(str=="venderDiv") {arr=vArr;codePart=$("[name=venderName]").eq(0).val();vn=2;}
	for(var i=0;i<arr.length;i++){
		pRow=table.insertRow(-1);
		$(pRow).attr({"onclick":"selectItem(this)","onMouseOver":"OMO1(event)","onDblClick":"choice(${i.index})","align":"center"});
		for(var j=0;j<=arr[i].length;j++){
			if(j==0) {cel=pRow.insertCell(0);cel.innerHTML="&nbsp;";}
			else {cel=pRow.insertCell(j);cel.innerHTML=arr[i][j-1];}
		}
	}
	table.insertRow(-1).innerHTML="<td class='title2'></td>";
	if(codePart!=""){
		var row=table.rows;
		var lr=row.length;
		for(var i=lr-2;i>0;i--){
			if(row[i].cells[vn].innerHTML.indexOf(codePart)==-1){
				table.deleteRow(i);
			}
		}
	}
	
}
  //添加一行
function addItem() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text' required name='productCode' size='10' oninput='color(this)' onblur='dataChoose(this)'><span class='LL'><image src='/SCM/images/selectDate.gif' onClick='choiceSpxx(" + (oRow.rowIndex - 1) + ",\"productDiv\")'></span><span class='requred_symbol'>*</span>";
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' required name='productName' size='15' readonly><span class='requred_symbol'>*</span>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' required name='unitName' size='10' readonly><span class='requred_symbol'>*</span>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' required name='num' size='10' value='0' oninput='prePayFeeInP(this)' onblur='prePayFeeBlr(this)'><span class='requred_symbol'>*</span>";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' required name='unitPrice' size='10' value='0' oninput='prePayFeeInP(this)' onblur='prePayFeeBlr(this)'><span class='requred_symbol'>*</span>";
	//oCell = oRow.insertCell(6);
	//oCell.innerHTML = "<input type='text' name='stsl' size='10' value='0' >";

	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<image src=\"/SCM/images/delete.gif\" class=\"LL\" onclick=\"delItem(" + oRow.rowIndex + ")\"/>";
}
	//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(index) {
	var detailTable = document.getElementById("detailTable");
	detailTable.deleteRow(index);
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (i = index; i < rowNum; i++) {
		detailTable.rows[i].cells[0].innerHTML = i;
		$(detailTable.rows[i].cells[1]).find("span:eq(0)").html("<image src='/SCM/images/selectDate.gif' onClick='choiceSpxx(" + (i - 1) + ",\"productDiv\")'>");
		detailTable.rows[i].cells[rowlength - 1].innerHTML = "<image src=\"/SCM/images/delete.gif\" class=\"LL\" onclick=\"delItem(" + i + ")\"/>";
	}
	setProductTotal();
}
function hiddenDiv() {
	document.getElementById(str).style.visibility = "hidden";
	clearTable();
}
function showDiv(){
	document.getElementById(str).style.visibility = "visible";
}
 

function clearTable() {
	var trs = spxxTable.rows;
	for (var i = 1; i < trs.length-1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}

