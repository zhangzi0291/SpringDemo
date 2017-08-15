<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
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
					<div class="box-title">访问记录列表</div>
				</div>
				<div class="box-body">
					<table id = 'table'  cellspacing="0"></table>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="toolbar">
<form class="form-inline" role="form">
	<div class="form-group">
		<label for="name" >时间：</label><input id="date"  />
	</div>
<!-- 	<div class="form-group"> -->
<!-- 		<label for="property" >出发站：</label><input id="startStation"  /> -->
<!-- 	</div> -->
<!-- 	<div class="form-group"> -->
<!-- 		<label for="property" >到达站：</label><input id="endStation"  /> -->
<!-- 	</div> -->
	
	<button id="search" class="btn btn-primary" type="button">搜索</button>
</form>
</div>
</body>
<jsp:include page="/jsp/jstool.jsp" flush="true"/>
<script type="text/javascript">
var $table
$(function(){
	initTable();
	initEvent();
})
function initEvent(){
	$('#date').daterangepicker({
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
	$("#search").on("click",function(){
			$table.bootstrapTable('refresh');
	})
	$table.on('load-error.bs.table', function (e, status) {
        console.log(e)
        console.log(status)
        layer.msg("加载错误")
    })
}
function initTable(){
	tableOption = getOption({
		url:basePath + "/ip/list.json",
		queryParams:function (params) {
			params.date=$("#date").val()
			params.startStation=$("#startStation").val()
			params.endStation=$("#endStation").val()
			return params;
		},
		columns:[	
			   { "title" : "check",   checkbox:true, },
			   { "title" : "访问IP",   "field": "ipAddress", },
			   { "title" : "访问时间",  "field" : "updateTime", sortable:true,
				   "formatter":function(value,row){
					   return new Date(value).Format("yyyy-MM-dd hh:mm:ss")
				   }
			   },
			   { "title" : "备注", "field" : "remark",  },

		  	],
	})
	$table=$("#table").bootstrapTable(tableOption);
}

</script>
</html>
