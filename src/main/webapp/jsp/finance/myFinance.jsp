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
							<label class="col-xs-4 control-label nopadding">预期还款日：</label>
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
		    <button type="button" class="btn btn-primary"  id="add">新增</button>
		    <button type="button" class="btn btn-warning"  id="edit">修改</button>
		    <button type="button" class="btn btn-danger" id="del">删除</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-primary"  id="check">审核</button>
			<button type="button" class="btn btn-primary"  id="evaluation">评价</button>
		</div>
	</div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="checkModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">确认申请</h4>
            </div>
            <div class="modal-body checkbody">
            </div>
            <div class="modal-footer text-center">
                <button type="button" class="btn btn-success"  id="checkOk">同意</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger " id="checkBad">拒绝</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框（Modal） -->
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
		window.location.href = basePath+"/finance/newFinance.html"
	})
	$("#edit").on("click",function(){
		var selects = $table.bootstrapTable('getSelections');
		if(selects.length != 1){
			layer.alert("请选择一条信息")
			return
		}
		window.location.href = basePath+"/finance/editFinance.html?id="+selects[0].id
	})
	$("#check").on("click",function(){
		var select = $table.bootstrapTable('getSelections');
		if(select.length != 1){
			layer.alert("请选择一条信息")
			return
		}
		$.ajax({
			type:"POST",
			url:basePath+"/finance/checkLoan",
			data:{
				id:select[0].id
			},
			success:function(data){
				if(data.state != 1){
					layer.alert("不是需要审核的单子")
					return
				}
				$("#checkModal").removeClass("modal-danger");
				$("#checkModal").modal("show");
				if(data.creditRate<=3){
					$("#checkModal").addClass("modal-danger");
				}
				var html = "<div> 该用户信用评分为 "+data.creditRate+"（5分以上值得信赖）</div>"
				html += "<div> 总共需要还款 "+data.sum+"元</div>"
				$(".checkbody").html(html);
			}
		})
	}) 
	$("#evaluation").on("click",function(){
		var select = $table.bootstrapTable('getSelections');
		if(select.length != 1){
			layer.alert("请选择一条信息")
			return
		}
		var flag;
		$.ajax({
			type:"POST",
			url:basePath+"/evaluation/checkevaluation",
			async:false,
			data:{
				id:select[0].id
			},
			success:function(msg){
				flag=msg
			}
		})
		if(flag=='true'){
			layer.alert("已评价过")
			return
		}
		window.location.href = basePath+"/evaluation/evaluation.html?id="+select[0].id
	}) 
	$("#checkOk").on("click",function(){
		var select = $table.bootstrapTable('getSelections');
		$.ajax({
			type:"POST",
			url:basePath+"/finance/acceptLoan",
			data:{
				id:select[0].id,
				check:"1"
			},
			success:function(msg){
				$("#checkModal").modal("hide");
				layer.alert("放款成功")
			}
		})
	})
	$("#checkBad").on("click",function(){
		var select = $table.bootstrapTable('getSelections');
		$.ajax({
			type:"POST",
			url:basePath+"/finance/acceptLoan",
			data:{
				id:select[0].id,
				check:"2"
			},
			success:function(msg){
				$("#checkModal").modal("hide");
				layer.alert("拒绝成功")
			}
		})
	})
	$("#search").on("click",function(){
		$.ajax({
			type:"POST",
			url:basePath+"/finance/myFinanceList",
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
	option.url = basePath + "/finance/myFinanceList";
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
	   { "title" : "操作",   "field": "option","width":"70px",
		   "formatter":function(value, row, index){
			   return [
			            "<a class=\"like\" href=\"javascript:viewInline('" + row.id +  "')\" title=\"申请贷款\">",
			            '<i class="fa fa-search-plus"></i>',
			            '</a>  ',
			            "<a class=\"like\" href=\"javascript:viewInline('" + row.id +  "')\" title=\"申请贷款\">",
			            '<i class="fa fa-search-plus"></i>',
			            '</a>  ',
			            "<a class=\"like\" href=\"javascript:viewInline('" + row.id +  "')\" title=\"申请贷款\">",
			            '<i class="fa fa-search-plus"></i>',
			            '</a>  '
			        ].join('')
			}   
	   },
	   { "title" : "融资金额",  "field" : "loanAmount", },
	   { "title" : "还款方式", "field" : "repaymentMethod",  },
	   { "title" : "利率", "field" : "interestRate", 
		   "formatter":function(value){
		   return value+"%"
			} 
	   },
	   { "title" : "预期还款时间",  "field" : "repaymentDate", 
		   "formatter":function(value){
			   return new Date(value).Format("yyyy-MM-dd")
		   }
	   },
	   { "title" : "借款人",  "field" : "repaymentManStr", },
	   { "title" : "状态", "field" : "state",  }
  	]
	$table=$("#table").bootstrapTable(option);
}
</script>
</html>
