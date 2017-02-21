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
					<div class="box-title">我的融资</div>
				</div>
				 <form action="${basePath }/loan/applyLoan.json">
				<div class="box-body">
					<div class="box-header with-border">
		              <h3 class="box-title">贷款申请</h3>
		            </div>
		            <div class="box-body">
		           		<input type="hidden" class="form-control" id="ud" name="id" readonly 
		                		value="${info.id} ">
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-cny"></i></span>
		                <input type="text" class="form-control" id="loanAmount" name="loanAmount" readonly
		                		value="${info.loanAmount} ">
		                <span class="input-group-addon">.00</span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-line-chart"></i></span>
		                <input type="text" class="form-control" id="interestRate" name="interestRate" readonly
		               		value="${info.interestRate} ">
		                <span class="input-group-addon">% </span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-credit-card-alt"></i></span>
		                <select class="form-control" id="repaymentMethod" name="repaymentMethod" >
		                	<option value="一次还款" ${info.repaymentMethod=='一次还款'?'selected':'' }>一次还款</option>
		                	<option value="分期还款" ${info.repaymentMethod=='分期还款'?'selected':'' }>分期还款</option>
		                </select>
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon"><i class="fa fa-calendar"></i></span>
						<input type="text" class="form-control" id="repaymentDate" name="repaymentDateStr"  readonly
								value="${info.repaymentDateStr}">
						<span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">总还款额</span>
						<input type="text" class="form-control" id="repaymentDate" name="repaymentDateStr"  readonly
								value="${info.loanAmount*info.interestRate/100 + info.loanAmount}">
						<span class="input-group-addon"></span>
		              </div>
		            </div>
				</div>
				<div class="box-footer">
					<input class="btn btn-info pull-right" type="submit"  value="确认申请"  >
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
	$( "#repaymentDate" ).datepicker({
		format: "yyyy-mm-dd",
		language:"zh-CN",
		todayHighlight:true,
		startDate:new Date()
	});
}
function initEvent(){
	
}
function initTable(){
	
}

</script>
</html>
