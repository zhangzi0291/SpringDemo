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
.queryBox>input{
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
					<div class="box-title">我的申请</div>
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
							<label class="col-xs-4 control-label nopadding">还款截止日：</label>
							<input id="repaymentDate1" class=" col-xs-3"    />
							<label class="col-xs-1 control-label  nopadding text-center"> -</label>
							<input id="repaymentDate2" class="col-xs-3"  />
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
		    <button type="button" class="btn btn-primary"  id="add">贷款申请</button>
		    <button type="button" class="btn btn-warning"  id="edit">修改</button>
		    <button type="button" class="btn btn-danger" id="del">删除</button>
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
	$( "#repaymentDate1" ).datepicker({
		format: "yyyy-mm-dd",
		language:"zh-CN",
		todayHighlight:true
	});
	$( "#repaymentDate2" ).datepicker({
		format: "yyyy-mm-dd",
		language:"zh-CN",
		todayHighlight:true
	});
}
function initEvent(){
	$("#add").on("click",function(){
		window.location.href = basePath+"/loan/newLoan.html"
	})
	$("#edit").on("click",function(){
		var selects = $table.bootstrapTable('getSelections');
		if(selects.length != 1){
			layer.alert("请选择一条还款")
			return
		}
		var isEnd
		$.ajax({
			type:"POST",
			url:basePath+"/loan/checkrepayment",
			async:false,
			data:{
				id:selects[0].id
			},
			success:function(msg){
				if(isEnd=='end'){
					layer.alert("已经还清贷款")
					return
				}
				isEnd = msg
			}
		})
		window.location.href = basePath+"/loan/editLoan.html?id="+selects[0].id
	})
	$("#del").on("click",function(){
		var select = $table.bootstrapTable('getSelections');
		if(select.length < 1){
			layer.alert("至少选择一条信息")
			return
		}
		for(var i=0;i<select.length;i++){
			$.ajax({
				type:"POST",
				url:basePath+"/finance/delete.json",
				async : false,
				dataType: 'text',
				data:{
					id:select[i].id,
				},
				success:function(msg){
					console.log(msg)
					if(msg=="exist"){
						layer.alert("已经达成协议不可删除")
						return
					}
					if(msg=="error"){
						layer.alert("删除错误")
						return
					}
					$table.bootstrapTable('selectPage', 1);
					$table.bootstrapTable('refresh');
					layer.alert("删除成功")
				}
			})
		}
	})
	$("#search").on("click",function(){
		$.ajax({
			type:"POST",
			url:basePath+"/loan/myLoanList",
			data:{
				loanAmount1:$("#loanAmount1").val(),
				loanAmount2:$("#loanAmount2").val(),
				interestRate1:$("#interestRate1").val(),
				interestRate2:$("#interestRate2").val(),
				repaymentDate1:$("#repaymentDate1").val(),
				repaymentDate2:$("#repaymentDate2").val(),
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
	option.url = basePath + "/loan/applicationLoanList";
	option.queryParams=function (params) {
		params.loanAmount1=$("#loanAmount1").val()
		params.loanAmount2=$("#loanAmount2").val()
		params.interestRate1=$("#interestRate1").val()
		params.interestRate2=$("#interestRate2").val()
		params.repaymentDate1=$("#repaymentDate1").val()
		params.repaymentDate2=$("#repaymentDate2").val()
		return params;
	}
	option.columns=[	
	   { "title" : "check",   checkbox:true, },
	   { "title" : "id",   "field": "id", },
	   { "title" : "融资金额",  "field" : "loanAmount", },
	   { "title" : "还款方式", "field" : "repaymentMethod",  },
	   { "title" : "利率", "field" : "interestRate", 
		   "formatter":function(value){
		   return value+"%"
			} 
	   },
	   { "title" : "还款截止时间",  "field" : "repaymentDate", 
		   "formatter":function(value){
			   return new Date(value).Format("yyyy-MM-dd")
		   }
	   },
	   { "title" : "状态", "field" : "stateStr",  }
  	]
	$table=$("#table").bootstrapTable(option);
}

</script>
</html>