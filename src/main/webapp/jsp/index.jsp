<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="csstool.jsp"%>
<style type="text/css">
	
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
		<div class="row">
			<div class="col-md-3 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-aqua"><i class="ion ion-social-yen"></i></span>
					<div class="info-box-content">
					  <span class="info-box-text">借出款：</span>
					  <span class="info-box-number">${money.LOANAMOUNT }<small>元</small></span>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-aqua"><i class="ion ion-archive"></i></span>
					<div class="info-box-content">
					  <span class="info-box-text">总贷款：</span>
					  <span class="info-box-number">${money.TOTAL }<small>元</small></span>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-aqua"><i class="ion ion-ios-refresh"></i></span>
					<div class="info-box-content">
					  <span class="info-box-text">剩余还款：</span>
					  <span class="info-box-number">${money.REPAYMENT }<small>元</small></span>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-aqua"><i class="ion ion-ios-refresh"></i></span>
					<div class="info-box-content">
					  <span class="info-box-text">适合贷款数：</span>
					  <span class="info-box-number">${canLoan }<small>元</small></span>
					  <span class="info-box-text">个人评价：<b>${user.creditRate }</b></span>
					</div>
				</div>
			</div>
		</div>
		<div class="box box-primary">
				<div class="box-header">
					<div class="box-title"></div>
				</div>
				<div class="box-body">
					<div id="LoanAmount"  class="col-md-6" style="height:400px;">
					
					</div>
					<div id="Repayment" class="col-md-6" style="height:400px;">
					
					</div>
				</div>
		</div>
	</section>
</div>
</body>  
<%@include file="jstool.jsp"%>
<script type="text/javascript" src="${basePath}/js/echarts.js"></script>
<script type="text/javascript">
$(function(){
	var loanAmount = echarts.init(document.getElementById('LoanAmount'));
	$.ajax({
		type:"post",
		url:basePath+"/analysis/getLoanAmount",
		success:function(data){
			var loanAmountOption = {
				    title: {text: '30天放款变化'},
				    toolbox: {
				        show: true,
				        feature: {
				            saveAsImage: {show: true}
				        }
				    },
				    grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},
				    xAxis: [{
				    	type: 'category',
				        data:data.map(function (item) {
			                return new Date(item.CREATE_DATE).Format("yyyy-MM-dd");
				        })
				    }],
				    yAxis: {
				    	 type: 'value'
				    },
				    series: [{
				        name: '放款量（元）',
				        type: 'line',
				        smooth: true,
				        data: data.map(function (item) {
			                return item.LOANAMOUNT;
				        })
				    }]
				};
				loanAmount.setOption(loanAmountOption);
		}
	})
	var repayment = echarts.init(document.getElementById('Repayment'));
	$.ajax({
		type:"post",
		url:basePath+"/analysis/getRepayment",
		success:function(data){
			var repaymentOption = {
				    title: {text: '30天贷款变化'},
				    toolbox: {
				        show: true,
				        feature: {
				            saveAsImage: {show: true}
				        }
				    },
				    grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},
				    xAxis: [{
				    	type: 'category',
				        data:data.map(function (item) {
			                return new Date(item.CREATE_DATE).Format("yyyy-MM-dd");
				        })
				    }],
				    yAxis: {
				    	 type: 'value'
				    },
				    series: [{
				        name: '放款量（元）',
				        type: 'line',
				        smooth: true,
				        data: data.map(function (item) {
			                return item.LOANAMOUNT;
				        })
				    }]
				};
			repayment.setOption(repaymentOption);
		}
	})
})
</script>
</html>