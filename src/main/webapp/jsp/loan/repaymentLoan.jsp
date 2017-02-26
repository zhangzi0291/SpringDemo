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
					<div class="box-title">贷款偿还</div>
				</div>
				 <form action="${basePath }/loan/repaymentLoan.json">
				<div class="box-body">
					<div class="box-header with-border">
		              <h3 class="box-title">贷款信息</h3>
		            </div>
		            <div class="box-body">
		            	<input type="hidden" class="form-control" id="ud" name="id" readonly 
		                		value="${info.id} ">
						<div class="input-group">
		                <span class="input-group-addon left-addon">总额</span>
		                <input type="text" class="form-control" id="sum" name="sum"  value="${info.loanAmount*info.interestRate/100 + info.loanAmount} " readonly
		                		placeholder="融资金额">
		                <span class="input-group-addon">.00</span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-cny"></i></span>
		                <input type="text" class="form-control" id="loanAmount" name="loanAmount"  value="${info.loanAmount} " readonly
		                		placeholder="融资金额">
		                <span class="input-group-addon">.00</span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-line-chart"></i></span>
		                <input type="text" class="form-control" id="interestRate" name="interestRate"  value="${info.interestRate} "readonly
		                		placeholder ="利率">
		                <span class="input-group-addon">% </span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-credit-card-alt"></i></span>
		                <select class="form-control" id="repaymentMethod" name="repaymentMethod" placeholder="还款方式"  disabled>
		                	<option value="一次还款" ${info.repaymentMethod=='一次还款'?'selected':'' }>一次还款</option>
		                	<option value="分期还款" ${info.repaymentMethod=='分期还款'?'selected':'' }>分期还款</option>
		                </select>
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-calendar"></i></span>
						<input type="text" class="form-control" id="repaymentDate" name="repaymentDateStr"  value="${info.repaymentDateStr} "readonly
								placeholder="还款日期">
						<span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">借款人</span>
						<input type="text" class="form-control" id="repaymentMan" name="repaymentManStr" value="${info.repaymentManStr} " readonly
								 placeholder="借款人">
						<span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">已还款</span>
						<input type="text" class="form-control" id="repaymentBalance" name="repaymentBalance"  placeholder="已还款" value="${info.repaymentBalance} " readonly>
						<span class="input-group-addon">.00</span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">还款额</span>
						<input type="number" class="form-control" id="repayment" name="repayment"  min="0" placeholder="还款额" value="" >
						<span class="input-group-addon">.00</span>
		              </div>
		              
		            </div>
				</div>
				<div class="box-footer">
					<input class="btn btn-info pull-right" id="up" type="submit"  value="提交"  >
				</div>
				</form>
			</div>
		</div>
	</section>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
$(function(){
	intiPage();
	initTable();
	initEvent();
})
function intiPage(){
// 	$( "#repaymentDate" ).datepicker({
// 		format: "yyyy-mm-dd",
// 		language:"zh-CN",
// 		todayHighlight:true,
// 		startDate:new Date()
// 	});
	var sum="${info.loanAmount*info.interestRate/100 + info.loanAmount}"
	var leftM="${info.repaymentBalance}";
	var repaymentMethod= "${info.repaymentMethod}";
	if(repaymentMethod=="一次还款"){
		$("#repayment").val(sum);
		$("#repayment").attr("readonly","readonly");
	}else{
		if(Number(sum)-Number(leftM) >0){
			$("#repayment").attr("max",Number(sum)-Number(leftM));
		}
	}
}
function initEvent(){
	$("#up").on("click",function(){
		var sum="${info.loanAmount*info.interestRate/100 + info.loanAmount}"
		var leftM="${info.repaymentBalance}";
		if($("#repayment").val()-0<=0){
			layer.alert("还款额不正确")
			return
		}
		if($("#repayment").val()-0>(sum-leftM)){
			layer.alert("请不要多还钱")
			return
		}
		$("#repaymentMethod").removeAttr("disabled"); 
		$("form").submit();
// 		$("#repaymentMethod").attr("disabled","disabled"); 
	})
}
function initTable(){
	
}

</script>
</html>
