<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="../csstool.jsp"%>
<style type="text/css">
.onclick{
	cursor:pointer;
}
.search-high{
	height: 30px;
	margin-bottom: 6px;
}
.queryBox{
  padding-left:0;
  padding-right:0;
}
.queryBox>label{
  padding-right:0;
}
.nopadding{
  padding-left: 0px;
  padding-right: 0px;
}
</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">

<jsp:include page="/jsp/header.jsp" flush="true"/>
<jsp:include page="/jsp/menu.jsp" flush="true"/>

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box box-primary">
				<div class="box-header">
					<div class="box-title">我的融资</div>
				</div>
				<div class="box-body">
					<div class="row" >
						<div class="col-xs-4 queryBox marginTop">
							<label class="col-xs-3 control-label">金额：</label>
<!-- 							<span class="col-xs-3">金额：</span> -->
							<input id="loanAmount1" class=" col-xs-3"    />
							<label class="col-xs-1 control-label  nopadding text-center"> -</label>
							<input id="loanAmount2" class="col-xs-3"  />
						</div>
						<div class="col-xs-4 queryBox marginTop">
							<label class="col-xs-3 control-label">利率：</label>
							<input id="interestRate1" class=" col-xs-3"    />
							<label class="col-xs-1 control-label  nopadding text-center"> -</label>
							<input id="interestRate2" class="col-xs-3"  />
						</div>
						<div class="col-xs-3 queryBox marginTop">
							<label class="col-xs-4 control-label nopadding">还款日期：</label>
							<input id="repaymentDate" class="col-xs-8"  />
							</select>
						</div>
						<div class="col-xs-1">
							<button id="search" class="btn btn-primary search-high search-btn" type="button">搜索</button>
						</div>
					</div>
					<table id = 'table'  cellspacing="0"></table>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="toolbar">
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group">
		    <button type="button" class="btn btn-primary">新增</button>
		    <button type="button" class="btn btn-warning">修改</button>
		    <button type="button" class="btn btn-danger">删除</button>
		</div>
	</div>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
var $table
var option = tableoption
$(function(){
	initPage();
	initTable();
	initEvent();
})
function initPage(){
	$( "#repaymentDate" ).datepicker({format: "yyyy-mm-dd"});
}
function initEvent(){
	$("#search").on("click",function(){
		console.log($table.options)
		$.ajax({
			type:"POST",
			url:basePath+"/getpoke",
			data:{
				loanAmount1:$("#loanAmount1").val(),
				loanAmount2:$("#loanAmount2").val(),
				interestRate1:$("#interestRate1").val(),
				interestRate2:$("#interestRate2").val(),
				repaymentDate:$("#repaymentDate").val(),
				"limit":tableoption.pageSize,
				"offset":0
			},
			success : function(data){
				console.log(data)
				$table.bootstrapTable('selectPage', 1);
				$table.bootstrapTable('load', data);
			}
		})
	})
}
function initTable(){
	option.url = basePath + "/finance/myFinanceList";
	option.queryParams=function (params) {
		params.loanAmount1=$("#loanAmount1").val()
		params.loanAmount2=$("#loanAmount2").val()
		params.interestRate1=$("#interestRate1").val()
		params.interestRate2=$("#interestRate2").val()
		params.repaymentDate=$("#repaymentDate").val()
		return params;
	}
	option.columns=[	
	   { "title" : "check",   checkbox:true, },
	   { "title" : "id",   "field": "id", },
	   { "title" : "融资金额",  "field" : "loanAmount", },
	   { "title" : "还款方式", "field" : "repaymentMethod",  },
	   { "title" : "利率", "field" : "interestRate", 
		   "formatter":function(value){
		   return value/100+"%"
			} 
	   },
	   { "title" : "预期还款时间",  "field" : "repaymentDate",  },
  	]
	$table=$("#table").bootstrapTable(option);
}

</script>
</html>
