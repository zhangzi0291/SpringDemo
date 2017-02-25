<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
			<div class="col-xs-6">
				<div class="box box-primary">
					<div class="box-header">
						<div class="box-title">基础信息 </div>
					</div>
					<c:if test="${fn:contains(header.referer,'myLoan.html')==true}">
						 <form id="eform" action="${basePath }/evaluation/evaluationLoan.json">
					 </c:if>
					<c:if test="${fn:contains(header.referer,'myLoan.html')==false}">
						 <form id="eform" action="${basePath }/evaluation/evaluation.json">
					 </c:if>
					<div class="box-body">
						<div class="box-header with-border">
<!-- 			              <h3 class="box-title"></h3> -->
			            </div>
			            <div class="box-body">
			          	 <input type="hidden" name="id"  value="${info.id} " >
			              <div class="input-group">
			                <span class="input-group-addon left-addon"><i class="fa fa-cny"></i></span>
			                <input type="text" class="form-control" id="loanAmount" name="loanAmount"  value="${info.loanAmount} " readonly
			                		placeholder="融资金额">
			                <span class="input-group-addon">.00</span>
			              </div>
			              <br>
			              <div class="input-group">
			                <span class="input-group-addon left-addon"><i class="fa fa-line-chart"></i></span>
			                <input type="text" class="form-control" id="interestRate" name="interestRate"  value="${info.interestRate} " readonly
			                		placeholder ="利率">
			                <span class="input-group-addon">% </span>
			              </div>
			              <br>
			              <div class="input-group">
			                <span class="input-group-addon left-addon"><i class="fa fa-credit-card-alt"></i></span>
			                <select class="form-control" id="repaymentMethod" name="repaymentMethod" placeholder="还款方式" disabled>
			                	<option value="一次还款" ${info.repaymentMethod=='一次还款'?'selected':'' }>一次还款</option>
			                	<option value="分期还款" ${info.repaymentMethod=='分期还款'?'selected':'' }>分期还款</option>
			                </select>
			                <span class="input-group-addon"></span>
			              </div>
			              <br>
			              <div class="input-group">
			                <span class="input-group-addon left-addon"><i class="fa fa-calendar"></i></span>
							<input type="text" class="form-control" id="repaymentDate" name="repaymentDateStr"  value="${info.repaymentDateStr} " readonly
									placeholder="还款日期">
							<span class="input-group-addon"></span>
			              </div>
			              <br>
			              <div class="input-group">
			                <span class="input-group-addon left-addon">借款人</span>
							<input type="text" class="form-control" id="repaymentMan" name="repaymentMan" value="${info.repaymentManStr} " readonly
									 placeholder="还款日期">
							<span class="input-group-addon"></span>
			              </div>
			              <br>
			              <div class="input-group">
			                <span class="input-group-addon left-addon">已还款</span>
							<input type="text" class="form-control" id="repaymentBalance" name="repaymentBalance"  placeholder="还款日期" value="${info.repaymentBalance} " readonly>
							<span class="input-group-addon"></span>
			              </div>
			              </form>
			            </div>
					</div>
					<div class="box-footer">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="box box-primary">
					<div class="box-header">
						<div class="box-title">我的评价</div>
					</div>
					<div class="box-body">
						<div class="box-header with-border">
<!-- 			              <h3 class="box-title">新建融资</h3> -->
			            </div>
			            <div class="box-body">
			           
			              <div class="input-group">
			                <input id="evaluationScore" type="number"  class="rating" min=0 max=5 step=0.5 data-size="sm" >
			              </div>
			              
			            </div>
					</div>
					<div class="box-footer">
						<input id="tijiao" class="btn btn-info pull-right" type="button"  value="提交"  >
					</div>
					
				</div>
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
	$("#tijiao").on("click",function(){
		var score = $("<input type='hidden'  name ='evaluationScore' />");
		var scoreNum=$("#evaluationScore").val()
		score.val($("#evaluationScore").val())
		$("#eform").append(score);
		$("#eform").submit();
		$("input[name=evaluationScore]").remove();
	})
}
function initTable(){
}

</script>
</html>
