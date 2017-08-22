<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>${title }</title>
<jsp:include page="/jsp/csstool.jsp" flush="true"/>
</head>
<body class="skin-blue fixed">
<jsp:include page="/jsp/header.jsp" flush="true"/>
<div class="wrapper">

<jsp:include page="/jsp/menu.jsp" flush="true"/>

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<div class="box-title">新增通知</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/train/add.json" method="post" class="form-horizontal">
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
						<div class="form-group">
							<label class="col-sm-2 control-label">出发站</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="fromStation">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">到达站</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="toStation">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">通知邮箱</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="emailAddress" placeholder="">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">预定日期</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="date">
	                        </div>
	                    </div>
						<div class="hr-line-dashed"></div>
						<div class="align-right">
							<input id="save" type="submit" class="btn btn-primary" value="保存" >
							<input id="back" type="button" class="btn btn-warning" value="返回">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</div>

<jsp:include page="/jsp/footer.jsp" flush="true"/>
</body>
<jsp:include page="/jsp/jstool.jsp" flush="true"/>
<script type="text/javascript">
$(function(){
	initEvent();
})
function initEvent(){
	$("#back").on("click",function(){
		window.history.go(-1)
	})
	$('input[name=date]').daterangepicker({
// 		timePicker : true,
//     	timePickerIncrement : 1, //时间的增量，单位为分钟
//     	timePicker12Hour : false, //是否使用12小时制来显示时间  
		singleDatePicker: true,
		showDropdowns: true,
		opens : 'right', //日期选择框的弹出位置				    	
		'applyClass' : 'btn-sm btn-success',
		'cancelClass' : 'btn-sm btn-default',					
		locale: {
			format: 'YYYY-MM-DD',
			applyLabel: '确定',
			cancelLabel: '取消',
			fromLabel: '从',
			toLabel: '到',
			weekLabel: '周',
			customRangeLabel: 'Custom Range',
			daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
			monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			firstDay: moment.localeData()._week.dow,
		}
	})
}

</script>
</html>
